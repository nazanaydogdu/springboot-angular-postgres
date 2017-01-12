(function(angular) {
  var ExamFactory = function($resource) {
    return $resource('/exams/:id', {
      id: '@id'
    }, {
      update: {
        method: "PUT"
      },
      remove: {
        method: "DELETE"
      }
    });
  };
  
  ExamFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("Exam", ExamFactory);
}(angular));