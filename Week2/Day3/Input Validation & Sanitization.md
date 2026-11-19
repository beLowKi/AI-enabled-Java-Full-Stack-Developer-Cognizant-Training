
This includes checks for oversized, invalid, or malicious inputs before a prompt is given to the model. Anything the model *does* receive should be sanitized such that it follows rules like these:

- Length limit
- Format check
- Allow-list
	- Accept only topics the app serves
- Deny-list
	- Blacklist known attack phrases
	- Negative language: "do not", "never" "must not"...
- Normalization
	- Convert look-alike characters
	- Remove invisible characters
	- Decode wrapped text

