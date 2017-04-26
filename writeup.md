Line \# | Fault Description | Fix Description
--- | --- | ---
52 | No else condition to use maxQueueSize | Added else condition to set capacity = maxQueueSize
68 | Method doesn't set the return value to depict sucess or not | set retVal = offer(arg0)
81 | Method element should return head, but it returns tail instead | Made it return the head
102 | Method peek should return head, but it returns tail instead | Made it return the head
112 | Method poll should return head, but it returns tail instead | Made it return head
147 | Tail starts at one, but should start at zero | Made it start at zero 
148 | Head starts at one, but should start at zero | Made it start at zero
172 | Method should throw new UnsupportedOperationException, but instead returns null | Made it throw the exception
209 | Integer myOffset uses tail, but it should use head | Changed it to use head