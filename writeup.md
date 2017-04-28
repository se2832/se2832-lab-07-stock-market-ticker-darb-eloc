##### Cole Abbeduto - abbedutocg@msoe.edu
##### Brad Wasilewski - wasilewski@msoe.edu

### 1. Introduction
**a. What are you trying to accomplish with this lab?**
In this lab we are attempting to learn how mock objects work and how to use them. I belive that it was mainly to learn Mockito which was well worth the time. Mockinto combined with Test-NG and other testing tools makes it so much easier to test things.

### 2. Testing Strategy
**a. What strategy did you use to create your test cases?**
We started with just trying to get method coverage where we had at least one test per method. Then after we started finding bugs we worked towards fixing them and then writing tests to make sure that they were fixed. This helped us later when we forgot to push up the fixes, but did remember to push up the tests. This caused a lot of tests to fail giving us an immediate feedback that something was wrong, which gave us just another reason to continue writing tests for our projects in the future. After that we worked towards line coverage and worked until we covered every line in the StockQuoteAnalyzer class.
**b. How did you go about coming up with stock values to use for testing?**
Most of the methods relied on getting information from the StockQuote objects in the StockQuoteAnalyzer class. This allowed to to rely heavliy on Mockito in order to create fake StockQuote objects and return them, therefore we knew what values should be returned either because we fed them to the StockQuote object, or mathed it out using those same numbers depending on what the method was supposed to do. 
**c. Did BVA or equivalence classes play any part in your stategy?**
Nope, as explained in part a, we went by method coverage, then by bug fixes, then by line coverage. No BVA or equivalence classes were used at all. 

### 3. Fault Locations
**a. Did you find any fault locations in your testing, and if so, how did you fix them?**
Yes, we were able to find a total of 7 problems, below is a table showing their original line number, a description of the fault, and how we were able to fix the fault.

Line \# | Fault Description | Fix Description
--- | --- | ---
83| constructor never checks if Audio Player is null | Added if statement checking in Audio Player is null
151 | getPreviousClose throws exception if currentQuote is equal to null | Changed != to ==
185 | getChangeSinceClose throws NullPointerException instead of InvalidAnalysisState | throw new InvalidAnalysisState instead of a new NullPointerException 
187 | getChangeSinceClose returns the wrong value | remove the subtraction of getClose()
204 | getPercentChangeSinceLastClose returns the wrong value | Remove the 100000 *, change /100 to *100, and include the *100 into the Math.round
219 | getChangeSinceLastCheck throws NullPointerExceptions instead of InvalidAnalysisState.  Method needs to either throw NullPointerExceptions or check for null objects and throw InvalidAnalysisState | Add in if statement to check for null objects, and throw InvalidAnalysisState
220 | getChangeSinceLastCheck always returns zero | Change the second currentQuote to previousQuote

### 4. Code Coverage
**a. What level of code coverage did you achieve over the StockQuoteAnalyzer class?**
We were able to get to 100% code coverage. At first we had belived that it wasn't possible due to an exception that didn't seem to ever able to be thrown due to it being a network error, but then after some reasearch into the cababilities of Mockito, we realized it was possible. Using Mockito, we were able to do the following code in order to force throw the exception when the current quote is fetched using the analayzer.refresh() method. 
~~~java
when(generatorMock.getCurrentQuote()).thenThrow(new StockTickerConnectionError());
~~~~

### 5. How did everything go?
**a. Things gone right**
We got 100% coverage
**b. Things gone wrong**
We did everything in master at first, then moved to dev. But I fixed it by doing a git reset --hard commit#, then donig a git push --force in order to force master back to that commit. So there is no history of us touching master until our pull request. Other than that I don't think anything went wrong. 

### 6. Conclusions
**a. What have you learned with this expirience?**
The concept of mock objects is really cool and the Mockito is extremely easy to use and I will definitly be using it again for testing bigger projects in the future. You can fake network connections or fake data that a method will return in order to test certain conditions in a method, that is super cool!!!

**b. What improvements can be made in this expirience?**
There was an exception being thrown according to the javadoc that I already notified you about that wasn't supposed to be there according to you. Other than that, I thinkn this was a nice balance of using Test-NG again and learning how to use Mockito and potentially other mock objects. If anything though, I would say more tests that require mock objects would be a bit better as there were only a few. 

