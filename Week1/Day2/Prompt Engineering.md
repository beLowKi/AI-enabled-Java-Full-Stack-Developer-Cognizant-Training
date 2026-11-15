
The practice of optimizing prompts sent to LLMs. It's intended to improve the accuracy, quality, and consistency of LLM output. Ideally, this is an iterative process where the successes/failures of previous prompts inform future ones.


#### Key Components of a Prompt

- Role
	- What is the AI acting as
	- Developer, Teacher, Tester, etc.
- Task
	- What specifically is the AI supposed to do
	- Should be highly specific and testable
- Context
	- Additional information (classes, services, other files, etc.) needed to understand and solve problem
	- Limited to only what's needed
- Constraints
	- Limitations like "no internet access" or "only edit these files"
- Output Format
	- Expected output type like JSON object(s), text, and so on


### Prompt Types

Although these are called "types",  many of them are techniques that can be used in tandem; i.e., a model could be prompted with a role (Role Prompting) and context (Contextual Prompting).

#### Zero-shot

No examples are given to copy and model must rely on pre-existing knowledge.

##### Examples

- Translating between languages "Translate '...' to French"
- Sentiment classification -> "Classify this review as positive, negative, neutral, etc."
- Summarizing text -> "Summarize these meeting notes into 3 sentences"
- Generating code -> "Make a Java class named Dog with 'bark' and 'walk' methods"
- Explaining a topic that the model

##### Pros

- Fastest to write
- Falls within model's baseline ability
- Cheapest: uses the fewest tokens because prompts are shorter
- Modern "instruction-tuned" models don't need strong guidelines for general tasks



#### One-shot / Few-shot

Includes one (one-shot) or several (few-shot) input-output examples in the prompt, so the model copies the pattern, tone or format. This type of prompt makes it easier to introduce limitations and output formats at the price of longer prompts.

##### Examples

- Data extraction by showing the model how and what to extract from text
- Quiz writing with a provided format and/or questions
- Brand tone -> "Here are two LinkedIn posts ...; use that tone to say ..."

##### Pros

- Custom formats
- More consistent
- Tone and style
- No fine-tuning required

#### Role (Persona) Prompting

AI is given a role/persona to exercise in its responses.

##### Examples

- Code review -> "You're a senior Java architect; review this code for ..."
- Compliance -> "You are an RBI compliance officer. List the risks in this customer-onboarding process"
- Teaching -> "You're a patient school teacher. Explain cloud computing to a 12-year-old"

##### Pros

- Tone and depth
	- Set vocab, depth, tone implicitly
- Domain framing
	- Can introduce expert thinking; i.e., implying which knowledge/skills the model should pull from like compliance for a banking auditor
- Audience fit
	- Tunes output to specific audiences like "Explain (topic) to me like I'm in 1st grade"
- Practice and simulation
	- Literally role-playing like practicing interviews or customer reviews

#### Instruction

Giving step-by-step directions describing exactly what the model should do, often as a numbered list of tasks.

##### Example

- "Write an email to the client 1) Thank them for the meeting 2) Confirming training dates..."
- "Refactor this method: rename variables...add null checks...add JavaDoc..."
- "Read this policy. First list the key rules, then flag anything unclear, then suggest two improvements"

##### Pros

- No guessing
	- Unambiguous instructions on what's expected of model
- Full coverage
	- (in theory) ensures every part of multi-part task is covered
- Repeatable
	- (in theory) prompt should produce similar output across LLM, user, or session
- Easy to debug
	- Task is very clear, so testing and debugging that it was completed is more simple

#### Chain-of-thought

Ask the model to give its reasoning step-by-step before giving the final answer either by saying so or providing an example.

##### Examples

- "A loan of .... Work out the EMI step by step, then give the final figure"
- "This code throws a NullPointerException. Walk through the execution line by line and fine the cause"

##### Pros

- Higher accuracy
- Visible reasoning
- Fewer careless jumps
- Builds trust

#### Contextual

Model is given background info (situation, audience, goal, documentation, etc.) so it fits the exact situation. This type is especially useful for use cases with niche requirements and/or limitations like needing to comply with specific company policies.

##### Examples

- "My audience is 20 mainframe developers moving to Java with no Spring experience. Suggest a 5-day Spring Boot agenda."
- "Our client is a mid-size bank migrating from IBM MQ to Kafka within 6 months on a fixed budget. Draft the approach section"
- "I'm repainting a north-facing living room with low natural light. Suggest three wall colors and why they suit it"

##### Pros

- Fits exact situation
	- Tunes generic answers to specific case
- Grounded answers
	- Reduces hallucination
- Private or recent data
	- Introduces info the model has never seen
- Basis of RAG
	- Retrieved documents are added as context to prompt 

#### Structured Output

Directing AI to given specific output format (JSON, XML, programming language, etc.). This one is most useful when integrating with code and other tools because of how consistent and machine-readable output can be.

##### Examples

- "Extract customer name, account type, and branch from this text. Return only JSON with keys name, accountType, and branch"
- "Generate test cases for the login API as a CSV with columns: ID, Scenario, Input, Expected Result"
- "Summarize this call using exactly these headings: Decisions, Action items (owner, due date), Open questions"

##### Pros

- Machine-readable
	- formats like JSON are easily passible to code or other tools
- Easy to compare
- Consistent documents
	- Output(s) is consistent and controllable
- Essential for apps

#### Prompt Chaining

A Large task is split into sequential, smaller prompts. The output of previous steps become the input of the next.

##### Examples

- "1) Write requirements for a fund-transfer API -> (2) Design the classes -> (3) Generate code -> (4) Generate unit tests for it"
- "(1) Define learning outcomes -> (2) Create modules for each -> (3) Write labs per module -> (4) Write the final assessment"

##### Pros

- Simpler steps
	- Smaller tasks are easier for the model to complete
- Checkpoints
- Easy to locate failures
- Foundation of agents
	- Agentic workflows rely on this type of prompting for tackling large tasks

#### Constraint / Negative

Setting limits and boundaries (length, scope, reading level, allowed sources, etc.) and state what the model must not do

##### Examples

- "Explain Kubernetes in exactly 50 words. Do not use the words 'container orchestration'."
- "Answer only from the text provided. If the answer is not in it, reply 'Not found in document'."
- "Suggest Java performance fixes. Use only Java 17 standard libraries; do not suggest third-part frameworks."

##### Pros

- Focused answers
- Blocks unwanted content
- Supports compliance
	- Works well if specific regulations need to be followed
- Saves effort
	- Stops model from spending time, and tokens, on things you don't want it to do

