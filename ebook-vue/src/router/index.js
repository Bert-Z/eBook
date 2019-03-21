import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import BookList from '@/components/BookList'
import BookDetails from '@/components/BookDetails'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/BookList',
      name: 'BookList',
      component: BookList
    },
    {
      path: '/BookDetails',
      name: 'BookDetails',
      component: BookDetails
    }
  ]
})
