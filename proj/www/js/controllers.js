var app = angular.module('starter.controllers', [])

app.controller('AllstarCtrl',["$scope", "$state","apiService", function($scope, $state, apiService) {
  console.info("ok allstart pane")

  apiService.getPostings(function(result){
    // todo fazer alguma coisa
    if(result.success){
      $scope.postings = result.data
    }else{
      alert(result.mensagem)
    }
    $scope.showDetail = function(item){
      apiService.setCurrent(item)
      $state.go("detail")
    }
  })
}]);

app.controller('AnimalCtrl',["$scope", "$state","apiService", function($scope, $state, apiService) {
  console.info("ok AnimalPrint pane")

  apiService.getPostings(function(result){
    // todo fazer alguma coisa
    if(result.success){
      $scope.postings = result.data
    }else{
      alert(result.mensagem)
    }
    $scope.showDetail = function(item){
      apiService.setCurrent(item)
      $state.go("detail")
    }
  })
}]);

app.controller('OutrasCtrl',["$scope", "$state","apiService", function($scope, $state, apiService) {
  console.info("ok Outras Categorias pane")

  apiService.getPostings(function(result){
    // todo fazer alguma coisa
    if(result.success){
      $scope.postings = result.data
    }else{
      alert(result.mensagem)
    }
    $scope.showDetail = function(item){
      apiService.setCurrent(item)
      $state.go("detail")
    }
  })
}]);

app.controller('DetailCtrl',["$scope","$state","apiService", function($scope, $state, apiService) {
    var obj = apiService.getCurrent()
    obj = apiService.getCurrent()
    if (!obj.title) {
      $stat.go("tab.allstar")
      return
    }
    $scope.detail = obj;

    $scope.goBack = function(){
      history.back()
    }
}]);
