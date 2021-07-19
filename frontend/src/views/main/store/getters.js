// getters
// 플랫폼 관련 정보 가져오기
export function getIsDesktopPlatform (state) {
  return state.isDesktopPlatform
}
// 메뉴 객체 가져오기
export function getMenus (state) {
	return state.menus
}
// Active된 메뉴 인덱스 가져오기
export function getActiveMenuIndex (state) {
  console.log("메뉴클릭4")
	const keys = Object.keys(state.menus)
  console.log("메뉴클릭5")
	return keys.findIndex(item => item === state.activeMenu)
}

// 토큰 가져오기
export function getToken (state) {
  return state.accessToken;
}
