PII (Personally identifiable information) should be redacted from model input and output where they're not authorized or expected. This section spoke mostly in reference to using external LLM providers whom a company wouldn't want to send their users' info.

- Detect
	- Find the PII in prompt
- Tokenize
	- Swap PII out for tokens
	- Store map in vault for restoring later
- Ask the LLM
	- Send tokenized prompt to LLM
- Get the reply
- Restore
	- Swap real values back for the user