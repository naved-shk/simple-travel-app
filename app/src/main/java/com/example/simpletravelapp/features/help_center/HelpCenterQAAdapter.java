package com.example.simpletravelapp.features.help_center;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpletravelapp.databinding.ListItemHelpCenterQaBinding;
import com.example.simpletravelapp.features.help_center.model.HelpCenterQA;

import java.util.List;

public class HelpCenterQAAdapter extends RecyclerView.Adapter<HelpCenterQAAdapter.ViewHolder> {

    List<HelpCenterQA> helpCenterQAList;

    public HelpCenterQAAdapter(List<HelpCenterQA> helpCenterQAList) {
        this.helpCenterQAList = helpCenterQAList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ListItemHelpCenterQaBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HelpCenterQA helpCenterQA = helpCenterQAList.get(position);
        holder.question.setText(helpCenterQA.getQuestion());

       boolean isExpanded = helpCenterQA.isExpanded();
       holder.cLExpandable.setVisibility(isExpanded? View.VISIBLE: View.GONE);

    }

    @Override
    public int getItemCount() {
        return helpCenterQAList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView question;
        private TextView answer;
        private ConstraintLayout cLExpandable;

        public ViewHolder(@NonNull ListItemHelpCenterQaBinding binding) {
            super(binding.getRoot());
            question = binding.tvQuestion;
            answer = binding.tvAnswer;
            cLExpandable = binding.clExpandable;

            question.setOnClickListener(v -> {
                    HelpCenterQA helpCenterQA = helpCenterQAList.get(getAdapterPosition());
                    helpCenterQA.setExpanded(!helpCenterQA.isExpanded());
                    notifyItemChanged(getAdapterPosition());
            });
        }

    }
}
