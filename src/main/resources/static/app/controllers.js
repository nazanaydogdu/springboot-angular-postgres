(function(angular) {
  var AppController = function($scope, Exam) {
    Exam.query(function(response) {
      $scope.exams = response ? response : [];
    });
    
    $scope.addExam = function(name, description) {
      new Exam({
        name: name,
        description: description,
        checked: false
      }).$save(function(exam) {
        $scope.exams.push(exam);
      });
      $scope.newExam = "";
    };
    
    $scope.updateExam = function(exam) {
      exam.$update();
    };
    
    $scope.deleteExam = function(exam) {
      exam.$remove(function() {
        $scope.exams.splice($scope.exams.indexOf(exam), 1);
      });
    };
  };
  
  AppController.$inject = ['$scope', 'Exam'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));