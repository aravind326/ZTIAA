
## Zero Trust Initial Account Activation (ZTIAA)

### 1) About the Project:


For organizations that make use of information systems for their staff to perform their tasks, it is required to have a mechanism to share credentials for the systems to new users joining the organization. If this mechanism is not secure, the credentials maybe disclosed and a malicious third-party can get access to the organization’s systems and data. This may lead to data exfiltration, data destruction, malware infestation or other forms of security breaches.

The existing solutions are not secure enough and are vulnerable to exploitation. As part of this project, I built a Zero Trust Initial Account Activation solution, that provides a secure means for users to activate their accounts when they join an organization. Information that is sent to the end user or their manager, is not adequate on its own to activate the account. The solution implements the principles of zero trust and requires the user and manager to perform real-time validation for a user to activate their account. When a user joins, they receive an activation link and an initial token for activation. The user must reach out to their manager using a secure channel (in-person, on a phone call, etc.) and provide the initial token to them. The manager can validate the token and retrieve an activation OTP, which they will relay back to the user. Using the OTP, the user can set a new permanent password, without ever knowing their temporary password.

The solution was evaluated for security, usability, and ease of adoption, while comparing it with solutions that exist currently. Based on the analysis, I was able to demonstrate that the Zero Trust Account Activation solution is more secure, equally usable, and easier for organizations to adopt than the other solutions.

While the solution is practical and secure in most scenarios, there are limitations that may make this solution not feasible for certain organizations. If organizations do not have a centralized identity repository or if their user identifiers are not unform across different applications, this solution will not be effective. Also, if a manager has a large number of users, they may find the user experience slightly cumbersome.

The solution has scope for future improvements as well. Support can be added for more secure verification options, such as biometrics or government ID based verification. The solution can also be improved to support configuration of password-less authentication mechanisms after verification. An API interface can be added to allow external systems such as identity governance tools to seamlessly integrate this solution as part of the enterprise account lifecycle management process.
