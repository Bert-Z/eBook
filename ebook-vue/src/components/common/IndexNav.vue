<template>
  <div class="common_nav">
    <Menu mode="horizontal" theme="dark" style="width: 100%">
      <Submenu v-for="ca in category2" v-bind:name="ca">
        <template slot="title">
          <span> <b class="hidden-xs">{{ca}}</b></span>
        </template>
        <div v-for="item in allCategories">
          <MenuItem v-if="item.category2 === ca" :name="item.category1"
                    @click.native="goto(item.id)">{{item.category1}}
          </MenuItem>
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
        allCategories: [],
        category2: []
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
            // console.log(this.allCategories);
          }, function (error) {
            console.log(error);
          }
        )
      },
      getCategory2: function () {
        this.$http({
          method: "GET",
          url: "http://localhost:8080/api/getCategory2",
          emulateJSON: true
        }).then(
          function (response) {
            this.category2 = response.data;
            // console.log(this.category2);
          }, function (error) {
            console.log(error);
          }
        )
      }
    },
    created() {
      this.getAllCategorys();
      this.getCategory2();
    }
  }
</script>

<style scoped>

</style>
