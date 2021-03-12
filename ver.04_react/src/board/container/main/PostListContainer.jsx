import { connect } from 'react-redux';
import PostList from '../../component/main/PostList';
import { resetPostList, requestPostList } from '../../redux/action/postListAction';

const mapStateToProps = (state) => {
  const { posts } = state.postList;
  return { posts };
};

const mapDispatchToProps = {
  resetPostList,
  requestPostList,
};

export default connect(mapStateToProps, mapDispatchToProps)(PostList);
