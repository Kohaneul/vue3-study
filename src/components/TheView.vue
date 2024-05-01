<template>
	<main>
	<div class="container py-4">
		<MyButton type="my-button" id="my-button" @click="sayHello"></MyButton>
		<LabelInput label="이름" data-id="data-id 입니다"></LabelInput>
		<hr/>
		<FancyButton>Click <span style="color:red">@@@</span></FancyButton>
		<FancyButton>
			<template #default="{fancyMessage}">
					{{ fancyMessage }}
			</template>
		</FancyButton>
		<hr>
		<AppCard>
			<template #header="{headerMessage}">
			{{ headerMessage }}
			</template>
			<template #footer="{footerMessage}">
			{{ footerMessage }}</template>
			<template #default="{helloMessage,childMessage}">
			{{ helloMessage }}
			<br>
			{{ childMessage }}
			</template>
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
	</div>
</main>
</template>

<script>

import AppCard from './AppCard.vue';
import MyButton from './MyButton.vue'
import LabelInput from './LabelInput.vue';
import FancyButton from './FancyButton.vue';
import { ref } from 'vue';
	export default {
		components:{MyButton,LabelInput, FancyButton,AppCard},
		setup(){
			const message = ref('메시지 입니다')
			return {message}
		}

		
		
	}
</script>

<style lang="scss" scoped>

</style>