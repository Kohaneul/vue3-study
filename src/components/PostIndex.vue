<template>
  <main>
		<div class="container py-4">
			<PostCreate @create-post="createPost"></PostCreate>
			<hr class="my-4"/>
			<div class="row g-3" >
				<div class="col col-4" v-for="post in posts" :key="post.id">
					<AppCard 
									 :title="post.title"
									 :contents="post.contents"
									 :is-like = "post.isLike"
									 :type="post.type"
									 @toggle-like="post.isLike = !post.isLike">
					</AppCard>
				</div>
			</div>

			<hr class="my-4">
			<LabelInput v-model="username" label="이름" class="parent-class" style="color: red" id="parent-id"></LabelInput>
			<LabelTitle v-model:title="username" label="제목"></LabelTitle>
			<Username v-model:firstname="firstname" v-model:lastname="lastname"></Username>
		</div>
	</main>
</template>

<script>
import PostCreate from '@/components/PostCreate.vue';
import LabelInput from '@/components/LabelInput.vue';
import {reactive,ref} from 'vue';
import AppCard from './AppCard.vue';
export default{
	components : {
		AppCard,PostCreate
	},
	setup(){
		const username=ref('');
		const firstname=ref('');
		const lastname=ref('');

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
	const createPost=(newPost)=>{
		let id = posts.length+1;
		newPost["id"] = id;
		newPost["isLike"]=false;
		newPost["contents"]="내용"+id;
		posts.push(newPost);
		console.log(newPost);
	}
		return {post,posts,obj,createPost,username,firstname,lastname,username}
	}
}
</script>

<style lang="scss" scoped>

</style>