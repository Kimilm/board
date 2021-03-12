import { connect } from 'react-redux';
import Paging from '../../component/main/Paging';
import { resetPostList, requestPostList } from '../../redux/action/postListAction';

const mapStateToProps = (state) => {
  const { pagination, posts } = state.postList;
  const { number, size } = pagination;

  return {
    searchParams: state.search.params,
    pageNumber: number || 1,
    hasNext: posts.length === size,
  };
};

const mapDispatchToProps = {
  resetPostList,
  requestPostList,
};

export default connect(mapStateToProps, mapDispatchToProps)(Paging);
