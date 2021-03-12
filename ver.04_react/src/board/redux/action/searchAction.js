export const SET_FILTER = 'search/SET_FILTER';

export function setFilter(params) {
  return {
    type: SET_FILTER,
    payload: { params },
  };
}
