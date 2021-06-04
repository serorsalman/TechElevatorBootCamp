<template>
  <div id="main">
    <div class="puppyInfo">
      <div class="dogs" v-for="dog in allTheDogs" :key="dog.id">
        Puppy Name: {{ dog.name }}
        <br />
        Puppy Weight: {{ dog.weight }}
        <br />
        Paper Trained? {{ dog.paperTrained }}
        <br />
        <!--Remember that dynamic route we defined? It's being called here: -->
        <router-link :to="{ name: 'display-detail', params: { id: dog.id } }"
          >Change Puppy's Data!</router-link
        >
        <br />
        <br />
        <img v-bind:src=dog.image alt="random doggo" width="200" />
      </div>
    </div>
  </div>
</template>

<script>
import puppyService from "@/services/PuppyService";

export default {
  data() {
    return { allTheDogs: []};
  },

  created() {
    puppyService
      .list()
      .then((dogData) => {
        this.allTheDogs = dogData.data;
      })
      .catch((err) => {
        console.error(err + " uh oh missing doggos!");
      });
  },
};
</script>
<style>
.puppyInfo {
    display: flex;
    justify-content: center;
}
.dogs {
  margin: 20px;
  width: 20%;
  background-color: cornflowerblue;
}
</style>`