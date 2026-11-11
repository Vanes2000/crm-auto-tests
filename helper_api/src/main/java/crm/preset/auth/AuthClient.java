package crm.preset.auth;

public class AuthClient {
}
//helper_api/src/main/java/crm/preset/
//        ├── auth/
//        │   └── AuthClient.java            // POST /v1/auth/sign_in → token
//        ├── api/
//        │   └── account/
//        │       └── AccountApiClient.java  // GET /get/form/account/{id}, POST /set/account
//        ├── db/
//        │   └── account/
//        │       └── AccountRepository.java // insertRoot (GeneratedKeyHolder), cleanup(id)
//        ├── generator/
//        │   └── account/
//        │       └── AccountPresetGenerator.java
//        ├── model/
//        │   ├── AccountContext.java        // record(long id, String token) — «под кем создаём»
//        │   └── AccountPreset.java         // record(id, login, password, role, context)
//        ├── role/
//        │   └── Role.java                  // enum с хардкодом пресета
//        ├── registry/
//        │   └── PresetRegistry.java        // ConcurrentHashMap<Long, AccountPreset> + <Long, String> tokens
//        └── lifecycle/
//              ├── PresetLifecycle.java       // @BeforeSuite: root, @AfterSuite: cleanup
//              └── PresetTestListener.java    // ITestListener: onTestFailure/onTestSkipped