
**Scenario:** Your company wants an external AI model (an LLM) to summarize customer support tickets. Tickets contain personal data, so no real personal data may be sent to the external AI. A software layer will hide the personal data first and restore it afterwards. You will carry out each of that layer's steps by hand.

## Task 1: Identify the PII

| PII value                | Type             | Category          | Why is it risky?                                                                                 |
| ------------------------ | ---------------- | ----------------- | ------------------------------------------------------------------------------------------------ |
| Priya Sharma             | Person name      | Direct identifier | Identifies a specific person on its own.                                                         |
| priya.sharma@example.com | Email addresss   | Direct identifier | Is unique address that could also be used to contact person                                      |
| 1 416-555-0198           | Phone number     | Direct identifier | Unique number that could be used to contact person                                               |
| 4111 1111 1111 1111      | Credit Card      | Direct identifier | Unique number that also links to financial info                                                  |
| 22 Maple Street, Toronto | Street Address   | Quasi-identifier  | Indicates where person might live                                                                |
| 123-456-789              | SIN              | Direct identifier | Unique identifier that could be used to impersonate someone                                      |
| Her                      | Gender pronoun   | Quasi-identifer   | Suggests the person's gender which could be used with other quasi-identifiers to find the person |
|                          | IP address       | Quasi-identifier  | Links to user's machine                                                                          |
|                          | Date of birth    | Quasi-identifier  | Exposes their age and could be used with other quasi-identifiers                                 |
|                          | Passport number  | Direct identifier | Could be used to find a lot of information about a person                                        |
|                          | Driver's license | Direct identifier | Contains lots of other direct identifiers like name, address, etc.                               |
|                          | Username         | Quasi-identifier  | Could be used to impersonate user or attempt to access their account                             |

### Quiz: Is it PIL?

| #   | Item                           | Your answer (Yes / No / Depends + reason)                                                              |
| --- | ------------------------------ | ------------------------------------------------------------------------------------------------------ |
| 1   | The word "Toronto"             | Depends on if part of address                                                                          |
| 2   | Order #12345                   | Depends on if order tracking only requires only the number; could leak other info like address or name |
| 3   | john@company.com               | Yes direct ID to a way to contact person                                                               |
| 4   | IP address 192.168.1.10        | Yes links to person's machine                                                                          |
| 5   | "The printer is out of paper." | No has no personal info                                                                                |
| 6   | Date of birth 1990-04-12       | Yes contains quasi-identifier of a person's date of birth                                              |
| 7   | Customer ID C-88231            | Yes IDs like these are usually unique; such a thing could be used to impersonate                       |
| 8   | Product name: Blue Kettle      | No has no personal info                                                                                |

## Task 2 Redaction by Hand

**Original Ticket:**

Ticket #4821
Customer Priya Sharma (priya.sharma@example.com, +1 416-555-0198) reports that
her card 4111 1111 1111 1111 was charged twice. She lives at 22 Maple Street,
Toronto. Her SIN is 123-456-789. Please escalate; Priya is very upset.

Redacted:

Ticket #4821
\[REDACTED_PERSON\] (\[REDACTED_EMAIL\], \[REDACTED_PHONE\]) reports that their
card \[REDACTED_CARD\] was charged twice. They live at \[REDACTED_ADDRESS\]. \[REDACTED_PERSON\]'s SIN is \[REDACTED_SIN\]. Please escalate; \[REDACTED_PERSON\] is very upset.

### 2.2 Ticket B

**Original Ticket:**

Ticket #5102
John Smith wrote in: "My login email is john.smith@mail.com, but please also
copy j.smith@work.org. Call me on 647-555-0111 (or +1 (647) 555 0111 if that
fails). I live at 15 Queen Street, Ottawa, and my car

**Redacted**

Ticket #5102
\[REDACTED_PERSON\] wrote in: "My login email is \[REDACTED_EMAIL1\], but please also
copy \[REDACTED_EMAIL2\]. Call me on \[REDACTED_PHONE1\] (or \[REDACTED_PHONE2\] if that fails). I live at \[REDACTED_ADDRESS\], and my card \[REDACTED_CARD\] was declined. My SIN is \[REDACTED_SIN\]. Thanks, \[REDACTED_PERSON\]."

### 2.3: Short Answer

Redaction could be an issue if tokenizing is one-way only; i.e., PII is converted to tokens like \[REDACTED_SIN\] but never converted back. This causes issues if the original value is required in the model's response.

## Task 3: Tokenization and the Mapping Table

### 3.1 Tokenize Ticket A

| Token   | Original value           | Type           |
| ------- | ------------------------ | -------------- |
| PERSON  | Priya Sharma             | Person name    |
| EMAIL   | priya.sharma@example.com | Email address  |
| PHONE   | 1 416-555-0198           | Phone number   |
| CARD    | 4111 1111 1111 1111      | Credit card    |
| ADDRESS | 22 Maple Street, Toronto | Street address |
| SIN     | 123-456-789              | SIN            |

### 3.2 Tokenize Ticket B

| Token   | Original value          | Type           |
| ------- | ----------------------- | -------------- |
| PERSON  | John Smith              | Person name    |
| EMAIL1  | john.smith@mail.com     | Email address  |
| EMAIL2  | **j.smith@work.org**    | Email address  |
| PHONE1  | 647-555-0111            | Phone number   |
| PHONE2  | +1 647-555-0111         | Phone number   |
| ADDRESS | 15 Queen Street, Ottawa | Street address |
| CARD    | 5500 0000 0000 0004     | Credit cart    |
| SIN     | 987-654-321             | SIN            |

### 3.3 Unmask an AI reply

John Smith asks support to contact john.smith@mail.com or j.smith@work.org, or call 647-555-0111. 5500 0000 0000 0004 was declined; verify the account at 15 Queen Street, Ottawa.

### 3.4 Reflection

1. It happens because there's no differentiation between first name and full name. It isn't a serious problem because it doesn't affect the functionality of the model or whoever is using it, but it may look unpolished.
2. The same value must get the same token so that the map is efficient and meaningful. If they received a new token every time, then a lot of redundant tokens would be created, and the map would be less useful.
3. If the AI changed PERSON_01 to "person 1", then an automated unmasking script looking for the former would miss it. That token would remain masked, and the output would be incomplete.

## Task 4: Designing a Secure Vault

|  #  | Question and options                                                                                                                                                                                                                                                    | Your answer + reason                                                                                                                                                                                  |
| :-: | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|  1  | Where should the mapping be stored?<br><br>A) Inside the message sent to the AI<br><br>B) In a plain text file next to the masked ticket<br><br>C) In an encrypted store on your own servers, separate from the masked text<br><br>D) In the AI provider's chat history | C<br><br>This prevents leakage to AI provider and attacks targeting local file through encryption.                                                                                                    |
|  2  | Where should the encryption key live?<br><br>A) In the source code<br><br>B) In a secrets manager<br><br>C) In an email to the team<br><br>D) In the same database as the mapping                                                                                       | B<br><br>A and C are too public, and D increases the damage of potential database leaks.                                                                                                              |
|  3  | How long should a mapping be kept?<br><br>A) Forever<br><br>B) Briefly: until the reply is unmasked, with an expiry as a safety net<br><br>C) Until a developer remembers to delete it<br><br>D) 10 years for audit                                                     | B<br><br>As soon as the data is no longer needed, it should be deleted to prevent unauthorized access.                                                                                                |
|  4  | Who should be able to read the mapping?<br><br>A) All developers<br><br>B) Only the service that unmasks replies<br><br>C) The AI provider<br><br>D) Customer-facing agents                                                                                             | B<br><br>Only the service involved with unmasking needs access to the mapping file.                                                                                                                   |
|  5  | One mapping per request, or one big mapping for all tickets? Explain in your own words.                                                                                                                                                                                 | One mapping per request<br><br>This makes unmapping more efficient because it doesn't require reading a large file, and it lowers the damage that would be caused if said file were to ever be leaked |

### 4.2 Write the vault policy

Only the unmapper may read the vault because of the sensitive information it contains.
The encryption key is stored in a secrets manager, never in the database, employee emails, source code, or any other publicly available location.

Each request gets its own mapping, which expires after use and is deleted after the unmapper handles its ticket. Developers/analysts cannot read raw mappings because of potential data leakage.

### 4.3 What if the vault leaks?

#### Harms to Customers

- Sensitive PII leakage
- Loss of faith in company
- Subsequent identity and/or financial fraud

#### Potential Responses

- Force all mappings to expire
- Disable unmapping until problem is resolved
- Trace logs to discover how mapping table leaked

## Task 5: The End-to-End Pipeline

My order E -> C -> G -> A -> F -> D -> B

### 5.2 Leak Check BEFORE Sending

- ■  John
- ■  Smith
- ■  john.smith@mail.com
- ■  j.smith@work.org
- ■  647-555-0111  and  0111
- ■  15 Queen Street
- ■  5500 0000 0000 0004
- ■  987-654-321

### 5.3 Live Experiment With an AI Chat

**Model response:**

The customer reports that their payment card was declined and provides their login email, an additional email for copying, and two alternative contact phone numbers. They also included their residential address, card details, SIN, and name in the message.

**Full conversation:**

![[Pasted image 20261116153315.png]]

### 5.4 Questions

1. No, the tokens weren't included. Granted, I did past the raw markdown which includes \ before each bracket, but it didn't even try.
2. Yes, it was still able to summarize the ticket without knowing the values associated with any of the tokens.

## Task 6 Reflection and Weak Spots

**Ticket C:**

Ticket #6007
Hi, I'm Jordan Lee (date of birth 1990-04-12). Order 123456789012 never
arrived. My IP address was 192.168.1.10 when I ordered. Reach me at
jordan.lee@mail.com.

### 6.1 Spot the Risks

1. Listing PII
	1. Jordan Lee
	2. 1990-04-12
	3. 192.168.1.10
	4. jordan.lee@mail.com
2. Likely false negatives
	1. Date of birth is year-month-day format which a hard-coded tokenizing tool might miss
3. Likely false positives
	1. The long order number

### 6.2 Write your Reflection

1. The order number may be flagged as a false positive because it's a large number; however, it doesn't expose any PII. Date of birth may be false negative depending on if the tokenizer only checks certain date formats.
2. Redaction is better when the information doesn't need to be included in the final response; e.g., if, for this ticketing system, developers didn't need certain user details like their address. Tokenization allows for those values to be re-added to model responses afterward.
3. No, based on Task 5, the AI wasn't affected by the masked text. It was able to summarize the ticket without any PII.
4. Masking doesn't remove attempted prompt injection. It also doesn't defend against general misuse of the model since it only handles what data the model receives not instructions.
