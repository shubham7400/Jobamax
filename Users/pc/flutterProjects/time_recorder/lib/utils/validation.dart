import 'dart:async';


mixin Validation {

  final firstNameValidate =
  StreamTransformer<String, String>.fromHandlers(handleData: (value, sink) {
    if (value.length == 0 || value.isEmpty) {
      sink.addError('Enter the first name');
    }else {
      sink.add(value);
    }
  });

  final lastNameValidate =
  StreamTransformer<String, String>.fromHandlers(handleData: (value, sink) {
    if (value.length == 0) {
      sink.addError('Enter the last name');
    }else {
      sink.add(value);
    }
  });

  final eMailValidate =
  StreamTransformer<String, String>.fromHandlers(handleData: (value, sink) {
    if (value.length == 0) {
      sink.addError('Enter the e-mail');
    } else if (!value.contains('@')) {
      sink.addError('The e-mail is invalid!');
    } else {
      sink.add(value);
    }
  });

  final passwordValidate =
  StreamTransformer<String, String>.fromHandlers(handleData: (value, sink) {
    if (value.length == 0) {
      sink.addError('Enter the password');
    } else if (value.length < 6) {
      sink.addError('The password must have at least 6 characters');
    }else {
      sink.add(value);
    }
  });

}