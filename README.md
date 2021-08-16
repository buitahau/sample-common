# Sample Project - Common Service

### Change on pom.xml

If use other url nexus repository, change url value of distributionManagement tag.

### Change on ~/.m2/settings.xml
Refer: https://mincong.io/2018/08/04/maven-deploy-artifacts-to-nexus/
```
<settings>
  <servers>
    <server>
      <id>nexus-snapshots</id>
      <username>[username]</username>
      <password>[password]</password>
    </server>
  </servers>
</settings>
```
