# Sky Java Spring Recs-engine

Recs-Engine is a Java Spring web service which is generating requested number of recommendations for url query. Each generated
recommendation is filtered by set of filters to check if it is filter out content that is already past 60% of its running
time with regards to provided recommendations window, it is discarded if not. Recommendations are generated until specified
number is generated and cached for 5 minutes using Memcached. Path to generate recommendations is /recs/personalised and following request parameters are required:

num - number of recommendations to generate
start - timestamp of beginning window for which to generate recommendations
end - timestamp of ending of window for which to generate recommendations
subscriber - unique identifier of subscriber Result is returned in XML format.

For example following http call:
[http://localhost:8080/recs/personalised?num=5&start=1433635775807&end=1433642495807&subscriber=foo](http://localhost:8080/recs/personalised?num=5&start=1415286463203&end=1415294605557&subscriber=foo)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<recommendations>
   <recommendations>
      <uuid>c9ce65da-2d6c-45b7-a008-e57c38afb20d</uuid>
      <start>1433635775807</start>
      <end>1433642495807</end>
   </recommendations>
   <recommendations>
      <uuid>9f5ed573-dd7a-42d6-8046-6331917eaafd</uuid>
      <start>1433606855807</start>
      <end>1433612315807</end>
   </recommendations>
   <recommendations>
      <uuid>be46b7da-ae48-4823-95e3-688aa8d8c081</uuid>
      <start>1433628755807</start>
      <end>1433635835807</end>
   </recommendations>
   <recommendations>
      <uuid>10fd137b-0532-42d3-b075-f97ac66a2b49</uuid>
      <start>1433626295808</start>
      <end>1433633315808</end>
   </recommendations>
   <recommendations>
      <uuid>715b085c-1a0c-4aa6-a031-ba436b8ed94a</uuid>
      <start>1433636495808</start>
      <end>1433643155808</end>
   </recommendations>
</recommendations>
```
