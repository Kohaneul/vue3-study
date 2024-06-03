<template>
	<main>
	<div class="container py-4">
		<MyButton @my-button = "hihi"></MyButton>
		<LabelInput label="label" data-id="hihi"></LabelInput>
		<hr/>
		<FancyButton>
			<template #default="{fancyMessage}">{{ fancyMessage }}</template>
		</FancyButton>

		<FancyButton>Click
			<span style="color:red">@@@</span>
		</FancyButton>

		<hr>
		<AppCard>
			<template #header="{headerMessage}">{{headerMessage}}</template>
			<template #default = "{helloMessage,childMessage}">
				{{ helloMessage}}
				<br> 
				{{ childMessage }}
			</template>
			<template #footer>ㄴㄴㄴ</template>			
			<!-- <template #header="{headerMessage}">
			{{ headerMessage }}
			</template>
			<template #footer="{footerMessage}">
			{{ footerMessage }}</template>
			<template #default="{helloMessage,childMessage}">
			{{ helloMessage }}
			<br>
			{{ childMessage }}
			</template> -->
			<!-- <template #[slotArgs]>제목입니다.</template> -->
			<!-- <template #default>내용입니다.</template> -->
			<!-- 암시적으로 default slot 입니다. -->
			<!-- <template #footer>푸터입니다.</template> -->

			<!-- <template #default="{childMessage,helloMessage}">
				{{ childMessage }}
				{{  helloMessage }} 
				{{ childMessage }} -->
			<!-- </template> -->
		</AppCard>
		<hr/>
		<AppCard>게시글 입니다.</AppCard>

		<hr>
		<h1>CommonPage 영역</h1>
<CommonPage></CommonPage>

	</div>
</main>
</template>

<script>

import AppCard from './AppCard.vue';
import MyButton from './MyButton.vue'
import LabelInput from './LabelInput.vue';
import FancyButton from './FancyButton.vue';
import CommonPage from "./CommonPage.vue";
import { ref } from 'vue';
	export default {
		components:{MyButton,LabelInput, FancyButton,AppCard,CommonPage},
		setup(){
			const message = ref('메시지 입니다')

			const hihi = (aa)=>{
				alert(aa+'!!!!!!');
			}

			return {message,hihi}
		}

		
		
	}
</script>

<style lang="scss" scoped>

</style>