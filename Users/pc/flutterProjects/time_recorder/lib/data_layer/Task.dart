
class Task {

  final int taskId;
  final String title;
  final String description;
  final int userId;
  final int createdRoleId;
  final int createDate;
  final bool isActive;
  final int taskType;


  Task.fromJson(Map<String,dynamic> json)
      : taskId = json['taskId'],
        title = json['title'],
        description = json['description'],
        userId = json['userId'],
        createdRoleId = json['createdRoleId'],
        createDate = json['createDate'],
        isActive = json['isActive'],
        taskType = json['taskType'];
}
