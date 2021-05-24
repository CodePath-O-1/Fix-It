package com.example.fixit;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fixit.databinding.ItemCommentBinding;
import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.parceler.Parcels;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{

    public static final String TAG = "CommentAdapter";
    private ItemCommentBinding itemCommentBinding;


    private Context context;
    private List<Comment> comments;
    private User postUser;

    public CommentAdapter(Context context, List<Comment> comments, User postUser){
        this.context = context;
        this.comments = comments;
        this.postUser = postUser;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        itemCommentBinding = ItemCommentBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemCommentBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Comment comment = comments.get(position);
        holder.itemCommentBinding.tvComment.setText(comment.getComment());
        holder.itemCommentBinding.tvTime.setText(comment.getTimestamp());
        ParseUser parseuser = comment.getUserId();

        User user = new User();
        user.setObjectID(parseuser.getObjectId());
        if(parseuser.getParseFile(User.KEY_PROFILE_IMAGE)!=null){
            user.setImage(parseuser.getParseFile(User.KEY_PROFILE_IMAGE));
        }
        user.setUsername(parseuser.getUsername());
        user.setLastName(parseuser.getString(User.KEY_LAST_NAME));
        user.setFirstName(parseuser.getString(User.KEY_FIRST_NAME));
        user.setIsProfessional(parseuser.getBoolean(User.KEY_IS_PROFESSIONAL));
        holder.itemCommentBinding.setUser(user);


        itemCommentBinding.ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, UserProfileActivity.class);
                i.putExtra("user", Parcels.wrap(user));
                i.putExtra("ParseUser", Parcels.wrap(parseuser));
                context.startActivity(i);
            }
        });

        //Comments can only be deleted by the creator
        ParseUser currentUser = ParseUser.getCurrentUser();
        itemCommentBinding.btnDelete.setVisibility(View.GONE);
        if(comment.getUserId().getObjectId().equals(currentUser.getObjectId())) {
            itemCommentBinding.btnDelete.setVisibility(View.VISIBLE);
            deleteComment(comment, position);

        }
    }

    public void clear() {
        comments.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Comment> list) {
        comments.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemCommentBinding itemCommentBinding;

        public ViewHolder(@NonNull ItemCommentBinding itemCommentBinding) {
            super(itemCommentBinding.getRoot());
            this.itemCommentBinding = itemCommentBinding;
        }


    }

    private void deleteComment(Comment comment, int position) {
        itemCommentBinding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Deleting comment in parse database
                comment.deleteInBackground(new DeleteCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e != null) {
                            Log.i(TAG, e.getMessage());
                            return;
                        }

                        // after deleting, update comment count
                        ParseQuery<Post> commentPost = ParseQuery.getQuery("Post");
                        commentPost.getInBackground(comment.getPostId().getObjectId(), new GetCallback<Post>() {
                            @Override
                            public void done(Post post, ParseException e) {
                                if(e != null) {
                                    Log.i(TAG, e.getMessage());
                                    return;
                                }
                                Log.i(TAG, "Post: " + post.getCommentsCount());
                                if(post.getCommentsCount() == null){
                                    return;
                                }else if(post.getCommentsCount().equals(1)){
                                    post.remove("commentsCount");
                                }else {
                                    post.increment("commentsCount", -1);
                                }
                                post.saveInBackground();
                                Log.i(TAG, "Post after: " + post.getCommentsCount());
                                Log.i(TAG, "Delete Comment Successful");

                                //delete seleted comment in the list
                                removeAt(position);

                                // need to reload the activity to update the number of comments above the recyle view
                                Intent i = new Intent(context, DetailPost.class);
                                i.putExtra("user",Parcels.wrap(postUser));
                                i.putExtra("post", Parcels.wrap(post));
                                context.startActivity(i);
                            }
                        });

                    }
                });

            }
            public void removeAt(int position) {
                comments.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, comments.size());
            }




    });

    }




}
