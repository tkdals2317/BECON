//commit 으로 가져오기

export function setPlatform (state, isDesktop) {
  state.isDesktopPlatform = isDesktop
}

export function setMenuActive (state, index) {
  console.log("메뉴클릭2")
	console.log('setMenuActive', state,index)
	const keys = Object.keys(state.menus)
	state.activeMenu = keys[index]
}

export function setMenuActiveMenuName (state, menuName) {
	state.activeMenu = menuName
}

