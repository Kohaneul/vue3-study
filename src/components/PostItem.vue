<template>
  <div class="card">
    <div class="card-body">
      <span class="badge bg-secondary">{{typeName}}</span>
      <h5 class="card-title red mt-2">{{title}}</h5>
      <p class="card-text">{{content}}</p>
      <a href="#" class="btn" :class="isLikeClass" @click="toggleLike">좋아요</a>
    </div>
  </div>

</template>

<script>
import {computed} from 'vue';
	export default {
		props:{
			type:{
				type:String,
				default:'news',
				validator:value=>{
					return ['news','notice'].includes(value)
				}
			},
			title:{
				type:String,
				required:true
			},
			content:{
				type:String,
			},
			isLike:{
				type:Boolean,
				default:true
			}
		},

		emits:['toggleLike'],

		setup(props, context){
			const isLikeClass = computed(()=>{
				return props.isLike ? 'btn-danger' : 'btn-outline-danger';
			})
			const param = computed(()=>{
				return props.param;
			})
			const typeName = computed(()=>{
				return	props.type === 'news'? '뉴스' : '공지사항';
		})
			const toggleLike = ()=>{
				context.emit('toggleLike');
			}

			return {isLikeClass,typeName,toggleLike,param}
		}
	}
</script>

<style lang="scss" scoped>

</style>