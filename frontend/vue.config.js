<<<<<<< HEAD
const URL = "i5d102.p.ssafy.io:8443";
// const URL = "localhost:8080";
=======
const URL = "3.36.67.58:8443";
//const URL = "localhost:8080";
>>>>>>> develop

module.exports = {
    devServer: {
      https: false,
      port: 8083,
      open: true,
      proxy: {
        '/api/v1': {
          target: `https://${URL}/`
        },
        '/api/v2': {
          target: `https://${URL}/`
        },
        '/groupcall': {
          target: `https://${URL}/`
        },
        '/upload': {
          target: `https://${URL}/`
        },
      },
      historyApiFallback: true,
      hot: true,
    },
    css: {
      requireModuleExtension: false // import 시에 경로에 .module 포함 안해도 됨.
    },
    lintOnSave: false,
  }
  