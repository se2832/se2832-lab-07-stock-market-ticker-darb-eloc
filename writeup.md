Line \# | Fault Description | Fix Description
--- | --- | ---
151 | getPreviousClose throws exception if currentQuote is equal to null | Changed != to ==
220 | getChangeSinceLastCheck always returns zero | Change the second currentQuote to previousQuote
219 | getChangeSinceLastCheck throws NullPointerExceptions instead of InvalidAnalysisState.  Method needs to either throw NullPointerExceptions or check for null objects and throw InvalidAnalysisState | Add in if statement to check for null objects, and throw InvalidAnalysisState
204 | maybe equation is incorrect | ?
187 | maybe equation is incorrect | ?
185 | getChangeSinceClose throws NullPointerException instead of InvalidAnalysisState | throw new InvalidAnalysisState instead of a new NullPointerException 

We have added a recommendation table to list code fixes that don't cause faults

Line \# | Recommendation Description | Fix Description
--- | --- | ---
65 | Comments say class throws StockTickerConnectionError, but method doesn't throw this exception | Change the comments
219 | getChangeSinceLastCheck's name is confusing since StockQuote has a getChange method but is not used in getChangeSinceLastCheck | Correct method name to getChangeInPriceSinceLastCheck
