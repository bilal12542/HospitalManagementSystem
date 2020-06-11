[1mdiff --git a/bin/.gitignore b/bin/.gitignore[m
[1mdeleted file mode 100644[m
[1mindex bf27f5e..0000000[m
[1m--- a/bin/.gitignore[m
[1m+++ /dev/null[m
[36m@@ -1,4 +0,0 @@[m
[31m-/HospitalManagementSystem.class[m
[31m-/Main.class[m
[31m-/Person.class[m
[31m-/Hospital.class[m
[1mdiff --git a/bin/Person.class b/bin/Person.class[m
[1mindex 13fedaa..a3e5fa3 100644[m
Binary files a/bin/Person.class and b/bin/Person.class differ
[1mdiff --git a/src/Hospital.java b/src/Hospital.java[m
[1mdeleted file mode 100644[m
[1mindex 24e3e50..0000000[m
[1m--- a/src/Hospital.java[m
[1m+++ /dev/null[m
[36m@@ -1,10 +0,0 @@[m
[31m-[m
[31m-public class Hospital {[m
[31m-	private int id;[m
[31m-	private String address, hospital_name;[m
[31m-	Hospital(int id, String address, String hospital_name){[m
[31m-		this.id = id;[m
[31m-		this.hospital_name = hospital_name;[m
[31m-		this.address = address;[m
[31m-	}[m
[31m-}[m
[1mdiff --git a/src/Person.java b/src/Person.java[m
[1mindex d2a1f38..59c873e 100644[m
[1m--- a/src/Person.java[m
[1m+++ b/src/Person.java[m
[36m@@ -2,11 +2,4 @@[m
 public class Person {[m
 	private String full_name, gender, address;[m
 	private int id, phone;[m
[31m-	Person (int id, String full_name, String gender, String address, int phone){[m
[31m-		this.id = id;[m
[31m-		this.full_name = full_name;[m
[31m-		this.address = address;[m
[31m-		this.gender = gender;[m
[31m-		this.phone = phone;[m
[31m-	}[m
 }[m
\ No newline at end of file[m
