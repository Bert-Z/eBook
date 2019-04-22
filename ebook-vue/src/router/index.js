import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import BookList from '@/components/BookList'
import BookDetails from '@/components/BookDetails'
import SignUp from '@/components/SignUp'
import SignIn from '@/components/SignIn'
import Admin from '@/components/AdminIndex'
import EditBook from '@/components/EditBook'
import ShoppingCart from '@/components/ShoppingCart'
import CheckOut from '@/components/CheckOut'
import AllOrders from '@/components/AllOrders'

Vue.use(Router)

export default new Router({
  mode : 'history',
  base:'/ebook/',
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/booklist/:category',
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
      path: '/shoppingcart',
      name: 'ShoppingCart',
      component: ShoppingCart
    },
    {
      path: '/checkout',
      name: 'CheckOut',
      component: CheckOut
    },
    {
      path: '/allorders',
      name: 'AllOrders',
      component: AllOrders
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
