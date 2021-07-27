// import http from '@/util/http-common';
export default {
    namespaced: true,
    state: {
        concertCategory:[
            {category:"HipHop"},
            {category:"Ballad"},
            {category:"Zazz"},
            {category:"Indi"}
        ]
    },
    getters: {
        getConcertCategory(state) {
            return state.concertCategory;
        },
        
    },
    mutations: {
        
  },
    actions: {
        
    },
  };
  