package cn.jiguang.imui.messages.viewholder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

import cn.jiguang.imui.BuildConfig;
import cn.jiguang.imui.R;
import cn.jiguang.imui.commons.models.IFile;
import cn.jiguang.imui.commons.models.IMessage;
import cn.jiguang.imui.messages.MessageListStyle;

/**
 * Created by sky on 2018/5/17.
 */

public class FileViewHoler <MESSAGE extends IMessage> extends AvatarViewHolder<MESSAGE> {
    private TextView mFileName;
    private TextView mFileStatus;
    private ImageView mFileIcon;
    private View mFileContainer;

    public FileViewHoler(RecyclerView.Adapter adapter, View itemView, boolean isSender){
        super(adapter, itemView, isSender);
        mFileName = (TextView) itemView.findViewById(R.id.aurora_iv_msgitem_filename);
        mFileStatus = (TextView) itemView.findViewById(R.id.aurora_iv_msgitem_filestatus);
        mFileIcon = (ImageView) itemView.findViewById(R.id.aurora_iv_msgitem_fileicon);
        mFileContainer = (View) itemView.findViewById(R.id.aurora_fl_msgitem_file_container);
    }

    @Override
    public void onBind(final MESSAGE message) {
        super.onBind(message);
        IFile ext = getExtend(message);
        if (ext == null) {
            return;
        }
        mFileName.setText(ext.getDisplayName());
        mFileIcon.setImageResource(GetFileIconRes(ext.getExtension()));
        mFileStatus.setText(ReadableFileSize(ext.getSize()));

        mFileContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mMsgClickListener!=null){
                    mMsgClickListener.onMessageClick(message);
                }
            }
        });
        mFileContainer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mMsgLongClickListener != null) {
                    mMsgLongClickListener.onMessageLongClick(message);
                } else {
                    if (BuildConfig.DEBUG) {
                        Log.w("MsgListAdapter", "Didn't set long click listener! Drop event.");
                    }
                }
                return true;
            }
        });
    }

    @Override
    public void applyStyle(MessageListStyle style) {
        super.applyStyle(style);
    }

    private String ReadableFileSize(long size){
        if(size <= 0) return "0";
        String units[] = new String[] {"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + units[digitGroups];
    }

    private int GetFileIconRes(String extension){
        Integer iconRedId = null;
        switch (extension) {
            case "xls":
            case "xlsx":
                iconRedId = R.drawable.file_ic_session_excel;
                break;
            case "ppt":
            case "pptx":
                iconRedId = R.drawable.file_ic_session_ppt;
                break;
            case "doc":
            case "docx":
                iconRedId = R.drawable.file_ic_session_word;
                break;
            case "pdf":
                iconRedId = R.drawable.file_ic_session_pdf;
                break;
            case "html":
            case "htm":
                iconRedId = R.drawable.file_ic_session_html;
                break;
            case "txt":
                iconRedId = R.drawable.file_ic_session_txt;
                break;
            case "rar":
                iconRedId = R.drawable.file_ic_session_rar;
                break;
            case "zip":
            case "7z":
                iconRedId = R.drawable.file_ic_session_zip;
                break;
            case "mp4":
                iconRedId = R.drawable.file_ic_session_mp4;
                break;
            case "mp3":
                iconRedId = R.drawable.file_ic_session_mp3;
                break;
            case "png":
                iconRedId = R.drawable.file_ic_session_png;
                break;
            case "gif":
                iconRedId = R.drawable.file_ic_session_gif;
                break;
            case "jpg":
            case "jpeg":
                iconRedId = R.drawable.file_ic_session_jpg;
                break;
            default:
                iconRedId = R.drawable.file_ic_session_unknow;
        }
        return iconRedId.intValue();
    }
}
