# Prompt Classification

## Prompt Type Reference

| Code | Prompt type | Clue to spot it |
| -------- | -------- | -------- |
| | | |
| | | |
| | | |
| | | |
| | | |
| | | |
| | | |
| | | |
| | | |

## Demo-Worksheet

| Prompt # | Type | Reason |
| -------- | -------- | -------- |
| 1 | ZS | Is plain question with no context, limitations, roles, etc. |
| 2 | RO | Explicitly defines the role of "seasoned CFO" |
| 3 | SO | Instructs model to output in specific JSON format |
| 4 | FS | Gives a few examples of what appears to be IT ticket classification |
| 5 | CT | Instructs the model to show its reasoning step by step |
| 6 | PC | Uses multiple prompts where previous outputs become input of next |
| 7 | CN | Uses negative of not mentioning vendor names |
| 8 | CX | Context of tester operations is provided |
| 9 | IN | Gives clear steps for the model to follow |
| 10 | ZS | No context, limitations, roles, etc. are provided |
| 11 | RO | Sets role as "cybersecurity auditor" |
| 12 | FS | Gives examples of subject lines from which a style should be determined and followed |
| 13 | CX | Gives context of an HR leave policy |
| 14 | ZS | Although "step by step" is included, model is not given multiple explicit instructions |
| 15 | SO | Model is told to output in specific format |
| 16 | CN | Constrains to 5-sentence-max and adds limitations using negative language |
| 17 | PC | Multiple sequential prompts used |
| 18 | ZS | Model is given nothing, so it would need to pull from existing knowledge |
| 19 | IN | Clear, sequential instructions are given |
| 20 | RO | Given role of "strict English grammar teacher" |
| 21 | CX | Context of the bakery business is provided |
| 22 | FS | A few examples of expected input and output are given |
| 23 | CN | Limits to not using technical jargon or exceeding 60 words |
| 24 | CT | Instructs on specific thoughts to go through before deciding |
| 25 | SO | Sets output format |
| 26 | PC | Uses several sequential prompts |
| 27 | ZS | Is plain coding task with no context, limitations, roles, etc. |
| 28 | RO | Explicitly defines the role of "travel agent" |
| 29 | IN | Gives clear ordered sections for the model to follow |
| 30 | CX | Context of the Jenkins pipeline file and error log is provided |
| 31 | FS | Gives an example of input and output before the new input to convert |
| 32 | CN | Limits to three bullets and uses negative language about adding opinions |
| 33 | SO | Instructs model to output as CSV with specific columns |
| 34 | CT | Instructs the model to work it out step by step |
| 35 | RO | Sets role as "experienced product manager" |
| 36 | PC | Uses multiple sequential steps where previous outputs become input of next |
| 37 | ZS | Is plain question with no context, limitations, roles, etc. |
| 38 | IN | Gives clear sequential instructions for the model to follow |
| 39 | CX | Context of the customers and the bank's goal is provided |
| 40 | CN | Limits to 120 words and uses negative language about hashtags and emojis |
| 41 | FS | Gives a couple of examples of the commit message format to follow |
| 42 | CT | Instructs the model to reason step by step through the causes |
| 43 | SO | Sets output as numbered list with specific fields |
| 44 | ZS | No context, limitations, roles, etc. are provided |
| 45 | RO | Sets role as "career counsellor" |
| 46 | IN | Gives clear numbered steps for the model to follow |
| 47 | PC | Uses multiple prompts where previous outputs become input of next |
| 48 | CX | Context of the sales figures and festive season is provided |
| 49 | CN | Constrains to under 10 characters and adds limitations using negative language |
| 50 | IN | Gives clear numbered steps for the model to follow |
