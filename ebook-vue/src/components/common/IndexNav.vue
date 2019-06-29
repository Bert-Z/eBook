<template>
  <div class="common_nav">
    <Menu mode="horizontal" theme="dark" style="width: 100%">
      <Submenu v-for="(value,name,index) in allCategories" v-bind:name="index">
        <template slot="title">
          <span> <b class="hidden-xs">{{name}}</b></span>
        </template>
        <div v-for="(item,itemindex) in value" v-if="itemindex<10">
          <MenuItem :name = "index" @click.native="goto(item[1])">{{item[0]}}</MenuItem>
        </div>
      </Submenu>
    </Menu>
  </div>
</template>

<script>
  export default {
    name: "IndexNav",
    data() {
      return {
        allCategories: {},
      }
    },
    methods: {
      goto(id) {
        // console.log(id);
        this.$router.push({name: "BookList", params: {category: id}});
        this.$router.go(0);
      },
      getAllCategorys: function () {
        this.$http({
          method: "GET",
          url: "http://localhost:8080/api/getAllCategorys",
          emulateJSON: true
        }).then(
          function (response) {
            this.allCategories = response.data;
            // console.log(response.data);
            console.log(this.allCategories);
          }, function (error) {
            console.log(error);
          }
        )
      }
    },
    created() {
      this.getAllCategorys();
    }
  }
</script>

<style scoped>

</style>
