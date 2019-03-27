import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import BookList from '@/components/BookList'
import BookDetails from '@/components/BookDetails'
import SignUp from '@/components/SignUp'
import SignIn from '@/components/SignIn'
import Admin from '@/components/AdminIndex'
import EditBook from '@/components/EditBook'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/booklist',
      name: 'BookList',
      component: BookList
    },
    {
      path: '/bookdetails',
      name: 'BookDetails',
      component: BookDetails
    },
    {
      path: '/signup',
      name: 'SignUp',
      component: SignUp
    },
    {
      path: '/signin',
      name: 'SignIn',
      component: SignIn
    },
    {
      path: '/admin',
      name: 'Admin',
      component: Admin
    },
    {
      path: '/admin/editbook',
      name: 'editbook',
      component: EditBook
    }
  ]
})
