import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080/api"
});

export default {
    list() {
        return http.get('/allPuppies');
    },

  get(id) {
    return http.get(`/puppy/${id}`);
  },

  // add a puppy to endpoint /newPuppy

  // update a puppy to endpoint /editPuppy

  // delete a puppy to endpoint /removePuppy/id
  create(puppy) {

  },

  update(puppy) {
  
  },

  delete(id) {
 
  }
}
