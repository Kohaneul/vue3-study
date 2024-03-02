<template>
  <main>
		<div class="container py-4">
			<PostCreate @create-post="createPost"></PostCreate>
			<hr class="my-4"/>
			<div class="row g-3" >
				<div class="col col-4" v-for="post in posts" :key="post.id">
					<AppCard :title="post.title" :contents="post.contents" :is-like = "post.isLike" :type="post.type"
						@click="post.isLike = !post.isLike"
						:obj="obj">
						</AppCard>
			</div>
			</div>
			<hr class="my-4">
			<LabelInput v-model="username" label="이름"></LabelInput>
			<LabelTitle v-model:title="username" label="제목"></LabelTitle>
			<Username v-model:firstname="firstname" v-model:lastname="lastname"></Username>
		</div>
	</main>
</template>

<script>
import PostCreate from '@/components/PostCreate.vue';
import LabelInput from '@/components/LabelInput.vue';
import LabelTitle from '@/components/LabelTitle.vue';
import Username from '@/components/Username.vue';

import {reactive,ref} from 'vue';
import AppCard from './AppCard.vue';
export default{
	components : {
		AppCard,PostCreate,LabelInput,LabelTitle,Username
	},
	setup(){
		const username=ref('');
		const firstname=ref('');
		const lastname=ref('');

		const createPost=(newPost)=>{
			console.log('createPost',newPost);
			posts.push(newPost);
			}
		const obj =reactive({
			title:'제목',
			contents:'내용'
		
		});
		const post = reactive({
			id:1,
			title:'제목2',
			contents:'내용2'
		});
		const posts = reactive([
		{
			id:1,
			title:'제목1',
			contents:'내용1',
			isLike:true,
			type:'news'
		},
		{
			id:2,
			title:'제목2',
			contents:'내용2',
			isLike:true,
			type:'news'

		}
		,{
			id:3,
			title:'제목3',
			contents:'내용3',
			isLike:false,
			type:'notice'

		},{
			id:4,
			title:'제목4',
			contents:'내용4',
			isLike:false,
			type:'news'
		},
		{
			id:5,
			title:'제목5',
			contents:'내용5',
			isLike:false,
			type:'news'

		}
	])
		return {post,posts,obj,createPost,username,firstname,lastname}
	}
}
</script>

<style lang="scss" scoped>

</style>