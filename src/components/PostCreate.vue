<template>
  <div class="row g-3">
    <div class="col col-1">
      <input type="checkbox" v-model="isLike" >
    </div>
    <div class="col col-2">
      <select v-model="type" class="form-select">
      <option value="news" selected>뉴스</option>
      <option value="notice">공지사항</option>
    </select>
    </div>
    <div class="col col-7">
      <input type="text" v-model="title" class="form-control"/>
    </div>
    <div class="col col-2 d-grid">
      <button class="btn btn-primary" @click="createPost">추가</button>
    </div>
  </div>
</template>

<script>
import {reactive,ref} from 'vue'
  export default {

   emits:{
    createPost:newPost=>{
      if(!newPost.title || !newPost.type){
        return false;
      }
      return true;
    }
   },
    setup(props,{emit}){
      const title = ref('');
      const type = ref('news');
      const isLike = ref(false);
      const createPost = ()=>{
        const newPost = {
          title:title.value,
          type:type.value,
          isLike:isLike.value,
        }
        emit('createPost',newPost)
        type.value='news';
        title.value='';
      }
      return {title,type,isLike, createPost};
    }

  }
</script>

<style lang="scss" scoped>

</style>