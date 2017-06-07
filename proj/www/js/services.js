
var app = angular.module('starter.services', [])
app.service("apiService",["$http",function($http){
  var baseuri= "http://localhost:8100/nozip"
  // url de busca das categorias
  var categoriesUrl = baseuri+"/categories"
  // variavel para a postagem corrente
  var current = {}
  // url de busca das postagem
  var postingsUrl =  baseuri+"/postings/0"
// executa uma chamada de requisição no servidor
//  e retorna as dados atraves do callback
// callback = function(data){
//  ....
// }
  this.getPostings = function(callback){
// ao responder com sucesso
    var onSuccess = function(response){
      console.info(JSON.stringify(response))
      callback({success: true, data: response.data})
    }
// ao responder com erro
    var onErro = function(response){
      console.info(JSON.stringify(response))
      // responder para o callback
      callback({success: false, mensagem: response.data})
    }
    $http.get(postingsUrl).then(onSuccess,onErro)
  }
  
  this.setCurrent = function(value){
    current = value
  }

  this.getCurrent = function(){
    return current
  }

}]);
