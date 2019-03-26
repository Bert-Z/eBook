import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import BookList from '@/components/BookList'
import BookDetails from '@/components/BookDetails'
import SignUp from '@/components/SignUp'
import SignIn from '@/components/SignIn'

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
    },
    {
      path: '/SignUp',
      name: 'SignUp',
      component: SignUp
    },
    {
      path: '/SignIn',
      name: 'SignIn',
      component: SignIn
    }
  ]
})
