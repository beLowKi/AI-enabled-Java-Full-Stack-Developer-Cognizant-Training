This involves making system (developer) prompts stronger: clearer roles, tasks, constraints & limitations, etc. 

| Clear role and scope  | State who the model is and what it's expected to do                                                                          |
| --------------------- | ---------------------------------------------------------------------------------------------------------------------------- |
| Delimiters            | Untrusted text should be wrapped in tags like <user_input> and ensure the model knows it's data not instruction              |
| Instruction hierarchy | System -> User -> RAG output and tool output; ensure prior instruction is never overridden by later ones                     |
| Fixed refusal script  | The model doesn't improvise refusal responses; gives exact, recurring message                                                |
| No secrets inside     | Sensitive data like API keys, internal URLs, and discount codes aren't included in the prompt                                |
| Least privilege       | Tools are given the lowest privilege required for what's expected: read-only database user, refund tool capped at $100, etc. |
