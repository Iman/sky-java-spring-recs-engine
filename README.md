# sky-java-spring-recs-engine


Recs-Engine is a Java Spring web service which is generating requested number of recommendations for url query. Each generated
recommendation is filtered by set of filters to check if it is filter out content that is already past 60% of its running
time with regards to provided recommendations window, it is discarded if not. Recommendations are generated until specified
number is generated and cached for 5 minutes using Memcached. Path to generate recommendations is /recs/personalised and following request parameters are required:

num - number of recommendations to generate
start - timestamp of beginning window for which to generate recommendations
end - timestamp of ending of window for which to generate recommendations
subscriber - unique identifier of subscriber Result is returned in XML format.

For example following http call:
[http://localhost:8080/recs/personalised?num=5&start=1415286463203&end=1415294605557&subscriber=asd](http://localhost:8080/recs/personalised?num=5&start=1415286463203&end=1415294605557&subscriber=asd)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<recommendations>
   <recommendations>
      <uuid>1f18536a-e86f-4781-9819-7b3e7d385908</uuid>
      <start>1415288463203</start>
      <end>1415289998492</end>
   </recommendations>
   <recommendations>
      <uuid>c3a6ac38-16b1-41da-83f8-077aff4841d6</uuid>
      <start>1415284772998</start>
      <end>1415289302319</end>
   </recommendations>
   <recommendations>
      <uuid>42d34321-3283-467c-89dd-36983d8e4f4e</uuid>
      <start>1415290983863</start>
      <end>1415294905557</end>
   </recommendations>
   <recommendations>
      <uuid>b5408d7c-688a-48f5-ae04-7d78765c3f3f</uuid>
      <start>1415289589667</start>
      <end>1415290372753</end>
   </recommendations>
   <recommendations>
      <uuid>4d6bf32d-11d8-4b82-9b2b-07bc612a6060</uuid>
      <start>1415290982236</start>
      <end>1415292219539</end>
   </recommendations>
</recommendations>
```
