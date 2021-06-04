    <template>
  <div id="main">
    <h1>Delete a dog</h1>
    <div class="puppyInfo">
      <div class="dogs" v-for="dog in allTheDogs" :key="dog.id">
        Puppy Name: {{ dog.name }}
        <br />
        Puppy Weight: {{ dog.weight }}
        <br />
        Paper Trained? {{ dog.paperTrained }}
        <br />
        <br />
        <input
          type="checkbox"
          v-bind:id="dog.id"
          v-on:change="adoptPupper($event)"
        />
        Adopt puppy?
        <br />
        <img v-bind:src="dog.image" alt="random doggo" width="200" />
      </div>
    </div>
  </div>
</template>

<script>
import puppyService from "@/services/PuppyService";

export default {
  data() {
    return { allTheDogs: [], adoptedDog: {} };
  },
  methods: {
    adoptPupper(event) {
      if (
        confirm(
          "Are you sure you want to adopt this doggo?  This action cannot be undone."
        )
      ) {
        if (event.target.checked) {
          this.adoptedDog = {
            id: event.target.id,
          };
          puppyService.delete(this.adoptedDog.id)
          .then(response => {
              if (response.status === 200){
                  alert("Pupper was adopted!");
                  this.$router.push("/logout");
              }
          })
          .catch (error => {
            if (error.response) {
              this.errorMsg =
                "Error adopting puppy. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Sad Doggo. Server could not be reached.";
            } else {
              this.errorMsg =
                "Extra Sad Doggo. Request could not be created.";
            }  
          });
        } else {
          this.oneToConvert = {};
        }
      }
    },
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