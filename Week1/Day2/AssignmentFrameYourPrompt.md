## Activity 1: Zero-Shot Prompting

Scenario: The company wants to classify customer feedback.

### Prompt

Classify this customer feedback into one of these categories: "Delivery Issue", "Payment Issue", "Product Quality", "Return / Refund", or "General Inquiry":

"I ordered a laptop five days ago. The delivery was promised within three days, but I haven't received it yet. I am very disappointed."

### Response

Delivery Issue

The customer’s complaint centers on a late shipment: the laptop was promised within three days, and five days later it still hasn’t arrived. There’s no mention of payment problems, product defects, or a return request.

## Activity 2: One-Shot Prompting

Scenario: ShopSmart wants to generate professional responses to customer complaints.

### Prompt

Here's an example of a typical customer interaction:

Customer: "My order arrived two days late."

Expected response: "We sincerely apologize for the delay. We understand the inconvenience caused and appreciate your patience."

Now, respond to this customer:

Customer: "I received a damaged mobile phone."

### Response

We’re very sorry that your mobile phone arrived damaged. We understand how frustrating this is, and we appreciate your patience while we make it right.

To resolve this quickly, please send us your order number and a few photos showing the damage, including the packaging. Once we have those, we can arrange a replacement or a full refund, whichever you prefer.

Thank you for letting us know, and again, our apologies for the inconvenience.

## Activity 3: Few-Shot Prompting

Scenario: ShopSmart wants to automatically identify customer sentiment.

### Prompt

Given these examples:

| Customer Feedback | Sentiment |
| ----------------- | --------- |
| Excellent product and fast delivery! | Positive |
| The product is average | Neutral |
| My order never arrived. Very dissapointed! | Negative |

Classify this feedback:

1. "The laptop performance is excellent."
2. "The delivery was okay, nothing special."
3. "I received the wrong product and nobody is helping me."

### Response

```markdown
Given these examples:

| Customer Feedback | Sentiment |
| ----------------- | --------- |
| Excellent product and fast delivery! | Positive |
| The product is average | Neutral |
| My order never arrived. Very dissapointed! | Negative |

Classify this feedback:

1. "The laptop performance is excellent."
2. "The delivery was okay, nothing special."
3. "I received the wrong product and nobody is helping me."
```

*Note model responded in markdown because that's what I pasted into chat. I found that interesting.

## Activity 4: Role-Based Prompting

Scenario: Customers need assistance understanding the return policy.

### Prompt

You are a proffessional customer support executive. Respond to this customer's query in language that is simple, polite, and compliant with these policies:

- Products can be returned within 7 days of delivery.
- Products must be unused.
- Original packaging is required.
- Some products may be non-returnable.

Here is the query:

"I purchased a washing machine 10 days ago. Can I return it?"

### Response

Dear Customer,

Thank you for reaching out to us, and I'm sorry for any inconvenience.

Our return policy allows products to be returned within 7 days of delivery. As your washing machine was purchased 10 days ago, it is unfortunately outside the return window, so we are unable to accept a return.

Please also note that returns require the product to be unused and in its original packaging, and some products, such as certain large appliances, may be non-returnable.

If your washing machine has a defect or is not working properly, please let us know. We would be happy to guide you on the next steps, such as warranty support or a repair request.

Thank you for your understanding. Please feel free to contact us if you need any further help.

Warm regards,
Customer Support Team

## Activity 5: Context-Based Prompting

Scenario: ShopSmart has introduced a 7-day return policy for eligible products.

### Prompt

Keep in mind these strict policy details in your response:

- Products can be returned within 7 days of delivery.
- Products must be unused.
- Original packaging is required.
- Some products may be non-returnable.

Now, answer this customer's query:

"I purchased headphones 5 days ago and opened the package. Can I return them?"

### Response

Yes, you may still be able to return them. Here is how our policy applies to your situation:

- **Timing:** Returns are accepted within 7 days of delivery, so at 5 days you're still inside the window. Don't wait much longer, though.
- **Condition:** The headphones must be unused. Opening the package is fine as long as you haven't actually used them. If they've been worn or played, they likely won't qualify.
- **Packaging:** Everything needs to go back in the original packaging, so hold on to the box and any inserts.
- **Non-returnable items:** Some products are non-returnable, and headphones can fall into that group, especially where hygiene is a concern. Check the product page or your order confirmation to see whether yours is eligible.

If the headphones are unused, in their original packaging, and not marked non-returnable, you should be able to start the return. I'd suggest doing that within the next day or two to stay safely inside the 7-day window.

## Activity 6: Instruction-Based Prompting

Scenario: The management wants a summary of customer complaints.

### Prompt

In your response, you must 1\) Identify the main complaint 2\) Summarize it in two sentences 3\) Suggest one possible improvement 4\) Use simplet business language

Summarize these complaints:

"Customers are complaining that their orders are arriving late. Some customers have received incorrect products, while others are unhappy with the time taken by customer support to resolve issues."

### Response

**1) Main complaint:** Late order deliveries.

**2) Summary:** Customers are unhappy that their orders are arriving late, and some have also received the wrong products. Others are frustrated with how long customer support takes to resolve their issues.

**3) Suggested improvement:** Work with shipping partners to set clearer delivery timelines, and add an order-check step before items ship to cut down on late and incorrect orders.

## Activity 7: Constraint-Based Prompting

Scenario: ShopSmart wants short responses for its chatbot.

### Prompt

Answer this customer's question without going over 40 words. Use simple English. Maintain a polite tone. No technical jargon, and only give one solution.

Customer query:

"How can I track my order?"

### Response

Thank you for asking! Please log in to your account and go to "My Orders." Click on your order, then select "Track Package." You will see where your order is right now. If you need more help, we are happy to assist you.

## Activity 8: Structured Output Prompting

Scenario. ShopSmart wants to extract customer information from support messages

### Prompt

Extract from this customer's message the following information into a JSON object:

- customerName: String
- productName: String
- orderId: String
- issue: String

Customer message:

"My name is Rahul Sharma. I purchased a Samsung Galaxy phone. My order number is SS10245, and I received a damaged product."

### Response

```json
{
  "customerName": "Rahul Sharma",
  "productName": "Samsung Galaxy phone",
  "orderId": "SS10245",
  "issue": "Received a damaged product"
}
```

## Activity 9: Completion-Style Prompting

Scenario: The marketing team wants AI to generate product descriptions.

### Prompt

Extend the given product description with 5 relevant benefits:

"The top five benefits of buying a Smart TV from ShopSmart are:"

### Response

The top five benefits of buying a Smart TV from ShopSmart are:

1. **Built-in streaming access.** Smart TVs come with Netflix, Disney+, YouTube, Prime Video, and other major apps preinstalled, so you can start watching right away without extra devices, cables, or subscriptions to a separate streaming box.

2. **Stunning picture and sound quality.** Models available through ShopSmart feature 4K Ultra HD resolution, HDR support, and enhanced audio technology, delivering sharp detail, vibrant colors, and immersive sound for movies, sports, and gaming.

3. **Voice control and smart home integration.** Use built-in voice assistants like Alexa or Google Assistant to search for shows, adjust the volume, or control compatible smart lights, thermostats, and speakers, all hands-free.

4. **Easy setup and regular updates.** Connect to Wi-Fi, sign in, and you're ready to go. Automatic software updates keep your TV secure and add new features and app improvements over time, so it stays current for years.

5. **Great value with trusted support.** ShopSmart offers competitive pricing, a wide range of brands and sizes to fit any budget, and reliable customer service, including warranty options and hassle-free returns, so you can buy with confidence.

## Activity 10: Iterative Prompt Refinement

Scenario: A developer initially writes this prompt:

"Write something about ShopSmart products."

The generated response is too generic and does not help the marketing team.

### 1st Iteration: Add a clear task

"Write the 5 most defining traits of ShopSmart products"

### 2nd Iteration: Add role and context

"
You are an experience e-commerce analyst. Recently, you've encountered a new business named ShopSmart which specializes in electronics. Here are some examples:

...

Write the 5 most defining characteristics of ShopSmart products.
"

### 3rd Iteration: Add constraints and output format

"
You are an experience e-commerce analyst. Recently, you've encountered a new business named ShopSmart which specializes in electronics. Here are some examples:

...

Write the 5 most defining characteristics of ShopSmart products. Do not describe a characteristic with more than 40 words, and don't use technical jargon. Output a JSON map whose keys are characteric names and values are their descriptions.
"

## Challenge Activity - Design Your Own Prompt

Write one comprehensive prompt that instructs the AI to:

1. Act as an intelligent shopping assistant.
2. Understand the customer's requirements.
3. Ask relevant questions.
4. Recommend suitable product categories.
5. Explain the benefits of recommendations.
6. Follow a polite and professional tone.
7. Never invent product prices, stock availability, or specifications.

Challenge: Use Role + Context + Task + Constraints + Output Format together.

### Prompt

Your role is an intelligent shopping assistant. Follow these guidelines:

1) Build an understanding of each customer's requirements
2) Ask relevent, clarifying questions only when necessary
3) Recommend suitable product categories if applicable
4) Explain the benefits of each provided redcommendation
5) Maintain a polite and professional tone
6) Never invent product prices, stock availability, or specifications; all referenced information must be verifiable
7) Output a JSON map with keys "productId" which maps to a valid product ID and "rationale" which maps to a String explaining to the user why they are seeing this recommendation
8) Recommendation rationales cannot exceed 40 words and must also follow guideline 5.
