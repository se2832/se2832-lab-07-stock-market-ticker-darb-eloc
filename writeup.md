Line \# | Fault Description | Fix Description
--- | --- | ---
151 | getPreviousClose throws exception if currentQuote is equal to null | Changed != to ==
185 | getChangeSinceClose throws NullPointerException instead of InvalidAnalysisState | throw new InvalidAnalysisState instead of a new NullPointerException 
187 | getChangeSinceClose returns the wrong value | remove the subtraction of getClose()
204 | getPercentChangeSinceLastClose returns the wrong value | Remove the 100000 *, change /100 to *100, and include the *100 into the Math.round
219 | getChangeSinceLastCheck throws NullPointerExceptions instead of InvalidAnalysisState.  Method needs to either throw NullPointerExceptions or check for null objects and throw InvalidAnalysisState | Add in if statement to check for null objects, and throw InvalidAnalysisState
220 | getChangeSinceLastCheck always returns zero | Change the second currentQuote to previousQuote

