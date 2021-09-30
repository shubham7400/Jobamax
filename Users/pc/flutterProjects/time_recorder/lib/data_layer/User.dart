
class User {

  final bool isLogin;
  final int role;
  final int userId;
  final String emailId;
  final String firstName;
  final String lastName;
  final String profileUrl;
  final String token;

  User.fromJson(Map<String,dynamic> json)
    : isLogin = json['isLogin'],
    role = json['role'],
    userId = json['userId'],
    emailId = json['emailId'],
    firstName = json['firstName'],
    lastName = json['lastName'],
    profileUrl = json['profileUrl'],
    token = json['token'];
}
