
| Case # | Learning (S/U) |           Type           | Reason                                                                                                                                        |
| :----: | :------------: | :----------------------: | --------------------------------------------------------------------------------------------------------------------------------------------- |
|   1    |       S        |        Regression        | You are determining a continuous value (sale price) from known features                                                                       |
|   2    |       S        |      Classification      | Classifying as spam/not spam from known features: subject, email, text content, etc.                                                          |
|   3    |       U        |        Clustering        | Shopper segments aren't predefined, and the AI is grouping based on patterns it finds                                                         |
|   4    |       S        |        Regression        | You could predict tomorrow's high based on past days' (historical data)                                                                       |
|   5    |       S        |      Classification      | Image classification with predetermined categories                                                                                            |
|   6    |       U        |    Association Rules     | Detecting if/then patterns with no predetermined "right" answers                                                                              |
|   7    |       S        |      Classification      | Uses historical data of confirmed fraud cases                                                                                                 |
|   8    |       U        |    Anomaly Detection     | Data is unlabeled, and the goal is to find outliers                                                                                           |
|   9    |       U        | Dimensionality Reduction | Literally "squashes" 1,000 dimensions into 2 axes                                                                                             |
|   10   |       S        |        Regression        | Learns to predict a continuous value based on known feature (hours studied)                                                                   |
|   11   |       U        |    Anomaly Detection     | Doesn't say if trained on known malignant tumors; looking for anomaly?                                                                        |
|   12   |       U        |        Clustering        | News archive is untagged and goal is to group into topics                                                                                     |
|   13   |       S        |      Classification      | Predicting 2 predefined outcomes                                                                                                              |
|   14   |       S        |        Regression        | Predicts continuous value (hourly bike cost)                                                                                                  |
|   15   |       U        |        Clustering        | Involves finding "land types" patterns with no predetermined label                                                                            |
|   16   |       S        |        Regression        | I believe this means predicting MPG (miles per gallon) which is a single, continuous value                                                    |
|   17   |       S        |      Classification      | Training data is pre-labeled                                                                                                                  |
|   18   |       U        | Dimensionality Reduction | No labels; reduces images to their "main" components                                                                                          |
|   19   |       U        |    Association Rules     | Determines which items are often bought together (associated), though I'm not sure if this is AI at all?                                      |
|   20   |       S        |      Classification      | Applicant history is known                                                                                                                    |
|   21   |       U        |    Anomaly Detection     | Involves finding outliers in everyday data                                                                                                    |
|   22   |       S        |        Regression        | Predicts a single value and could pull from known stock information                                                                           |
|   23   |       S        |      Classification      | Labels are explicitly mentioned, but supervised is necessary for species name to be known; otherwise, would just group similar-specied irises |
|   24   |       U        |        Clustering        | Songs aren't pre-labeled with genres but must be grouped somehow                                                                              |
|   25   |       S        |        Regression        | Predicts single number from known info                                                                                                        |
|   26   |       S        |      Classification      | Trained on labeled documents                                                                                                                  |
|   27   |       U        |        Clustering        | Finding patterns in unlabeled tickets                                                                                                         |
|   28   |       S        |        Regression        | Guessing single number (age) from known data                                                                                                  |
|   29   |       S        |      Classification      | Predicting predetermined outcomes (has(n't) diabetes)                                                                                         |
|   30   |       U        | Dimensionality Reduction | No labels, just reducing word embedding vectors which, to my understanding, usually have hundreds of dimensions, to just 2                    |
|   31   |       S        |        Regression        | Outputs single, continuous value from input                                                                                                   |
|   32   |       U        |    Anomaly Detection     | There are no labels, so a failure could be detected through any anomalies in an otherwise functioning server                                  |
|   33   |       S        |      Classification      | Classifying to specific employees would require labelled images                                                                               |
|   34   |       U        |        Clustering        | Labels not mentioned, so would be recognizing patterns in documents to determine their similarity                                             |
|   35   |       S        |        Regression        | Outputs single number, and could be trained on energy use in past months                                                                      |
|   36   |       U        |    Association Rules     | Determining associated web pages with no premade labels                                                                                       |
|   37   |       S        |      Classification      | Training data is pre-tagged                                                                                                                   |
|   38   |       S        |      Classification      | Predicting will/won't rain forecast, and could be trained on past days' weather                                                               |
|   39   |       U        |    Anomaly Detection     | Learns a bank account's usual patterns in order to detect and flag unusual spending                                                           |
|   40   |       S        |        Regression        | Predicting single value based on past weeks                                                                                                   |
|   41   |       S        |      Classification      | Groups (diseases) are predetermined                                                                                                           |
|   42   |       U        |        Clustering        | Communities are not known beforehand                                                                                                          |
|   43   |       S        |        Regression        | Determines single value from known data                                                                                                       |
|   44   |       S        |      Classification      | Training data is pre-labeled                                                                                                                  |
|   45   |       U        | Dimensionality Reduction | Reducing survey data to key points                                                                                                            |
|   46   |       S        |        Regression        | Predicting single value from known info                                                                                                       |
|   47   |       U        |    Association Rules     | Nothing is prelabeled; model must learn associations while training                                                                           |
|   48   |       S        |      Classification      | Categories are preknown                                                                                                                       |
|   49   |       U        | Dimensionality Reduction | Literally "compressing" data dimensions from 200 to 10                                                                                        |
|   50   |       S        |        Regression        | Assuming star system does 1.5, 3.3, etc., this outputs single, continuous value                                                               |



## Reflection Questions

1. Pick two cases that both use the word detect but landed in different paradigms. What made the difference?

Case 26 -> S (Classification)
Case 32 -> U (Anomaly Detection)

Case 32 explicitly stated that server failures were not labeled, so it had to be unsupervised.
	

2. Case 38 asks for a probability. Why is it still classification and not regression?

I understood this case to not want the model to output a probability (e.g., 30% chance to rain). 
Instead, it's worded as if it wants a Boolean will/won't rain return which is classification.


3. Case 50 could be argued either way. State both arguments and say which you would choose and why.

Assuming the star system doesn't allow mid-star values like 1.5 or 3.5, then it would be a classification problem because there's no continuity between stars.
Otherwise, it'd have to be regression to allow for decimals between stars.

Every star system I've ever used has been the latter, continuous type, so I chose regression.


4. Give one new example of your own for each of the six problem types.

Case 51 (Classification): 
	"Determine if an image is a Pokémon, Digimon, or Neo Pet" 

Case 52 (Regression):
	"Predict how many Google results a topic has"

Case 53 (Clustering):
	"Determine similar YouTube videos to support auto-generated playlists"

Case 54 (Dimensionality Reduction):
	"Condense data from a 100 question personality test into 10 axes"

Case 55 (Association Rules):
	"Predict games that are likely to be enjoyed by players based on their Steam library"

Case 56 (Anomaly Detection):
	"Flag unusual player inputs from unlabeled user data"
