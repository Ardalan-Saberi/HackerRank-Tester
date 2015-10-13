# HackerRank-Tester
Small java gradle project to quickly create a native  test environment for your HackerRank java challenges. This way you'll only need download the test cases and do the coding in your own IDE offline..

This Project also contains some of the challenges I solved.

How?

- Start by building the project
- For every new hacker rank challenge, create class "hr.challenges.{{Challenge Name}}.Solution" in "/src/java/main". This is where you write your code.
- For each sample input create a file named "src/java/main/resources/hr/challenges/{{Challenge Name}}/t{{Test Case Number 0,1,...}}.in"
- For respective sample  outputs create files named "src/java/main/resources/hr/challenges/{{Challenge Name}}/t{{Test Case Number 0,1...}}.ans"
- Create a test class named "hr.Challenges.{{Challenge Name}}.SolutionTest" and copy contets from any of SolutionTest.Java unit tests
- Now run your SolutionTest, and make sure all tests pass, then submit your answer. Good Luck.

What's Next
- Converting this to a maven archtype, or a gradle starter which creates a project given a link to a HackerRank Challenge (automating all above steps)
- Separate solved challenges from the project archtype.
