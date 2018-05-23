//
//  IMUIFileMessageCell.swift
//  RCTAuroraIMUI
//
//  Created by sky on 2018/5/19.
//  Copyright © 2018 HXHG. All rights reserved.
//

import UIKit

class IMUIFileMessageCell: IMUIBaseMessageCell {
    
    var iconImageView = UIImageView()
    var fileNameLabel = UILabel()
    var fileStatusLabel = UILabel()
    var subContentView = UIView()
    let screenW = UIScreen.main.bounds.size.width
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        iconImageView.frame = CGRect(origin: CGPoint(x: 10, y: 10), size: CGSize(width: 49, height: 60))
        iconImageView.contentMode = UIViewContentMode.scaleToFill
        fileNameLabel.textColor = UIColor.black
        fileNameLabel.numberOfLines = 0
        fileNameLabel.font = screenW<375 ? UIFont.systemFont(ofSize:14) : UIFont.systemFont(ofSize: (screenW * 15 / 375))
        fileNameLabel.lineBreakMode = NSLineBreakMode.byTruncatingMiddle
        fileStatusLabel.textColor = UIColor.black
        fileStatusLabel.numberOfLines = 0
        fileStatusLabel.font = screenW<375 ? UIFont.systemFont(ofSize:11) : UIFont.systemFont(ofSize: (screenW * 12 / 375))
        subContentView.addSubview(iconImageView)
        subContentView.addSubview(fileNameLabel)
        subContentView.addSubview(fileStatusLabel)
        bubbleView.addSubview(subContentView)
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func layoutSubviews() {
        super.layoutSubviews()
    }
    
    override func presentCell(with message: IMUIMessageModelProtocol, viewCache: IMUIReuseViewCache , delegate: IMUIMessageMessageCollectionViewDelegate?) {
        super.presentCell(with: message, viewCache: viewCache, delegate: delegate)
        let layout = message.layout
        let tmpDict = message.customDict
        let fileLength = tmpDict.object(forKey: "fileLength") as! String
        let strDisplayName = tmpDict.object(forKey: "displayName") as! String
        self.fileNameLabel.frame = CGRect(origin: CGPoint(x: 70, y: 10.0), size: CGSize(width: (layout.bubbleFrame.size.width-80), height: 40))
        self.fileNameLabel.text = strDisplayName
        self.fileStatusLabel.frame = CGRect(origin: CGPoint(x: 70, y: 48), size: CGSize(width: (layout.bubbleFrame.size.width-80), height: 30))
        self.fileStatusLabel.text = readableFileSize(with: fileLength)
        iconImageView.image = UIImage.init(named: getFileIconRes(with: strDisplayName))
        self.subContentView.frame = CGRect(origin: CGPoint.zero, size:layout.bubbleFrame.size)
    }
    
    func readableFileSize(with fileLength : String) -> String {
        var digitGroups = 0
        let fileSize: Float64? = Float64(fileLength)
        var length = fileSize!
        print(length)
        let units = ["B", "KB", "MB", "GB", "TB"]
        while( length > 1024) {
            length = length / 1024
            digitGroups = digitGroups + 1
        }
        return String(format: "%4.2f%@", length, units[digitGroups])
    }
    
    func getFileIconRes(with fileName: String) -> String {
        let fileExtension = URL(fileURLWithPath: fileName).pathExtension ?? ""
        var iconRes = ""
        switch fileExtension {
        case "xls":
            iconRes = "file_excel"
            break;
        case "xlsx":
            iconRes = "file_excel"
            break;
        case "ppt":
            iconRes = "file_ppt"
            break;
        case "pptx":
            iconRes = "file_ppt"
            break;
        case "doc":
            iconRes = "file_word"
            break;
        case "docx":
            iconRes = "file_word"
            break;
        case "pdf":
            iconRes = "file_pdf"
            break;
        case "html":
            iconRes = "file_html"
            break;
        case "htm":
            iconRes = "file_html"
            break;
        case "txt":
            iconRes = "file_txt"
            break;
        case "rar":
            iconRes = "file_rar"
            break;
        case "zip":
            iconRes = "file_zip"
            break;
        case "7z":
            iconRes = "file_zip"
            break;
        case "mp4":
            iconRes = "file_mp4"
            break;
        case "mp3":
            iconRes = "file_mp3"
            break;
        case "png":
            iconRes = "file_png"
            break;
        case "gif":
            iconRes = "file_gif"
            break;
        case "jpg":
            iconRes = "file_jpg"
            break;
        case "jpeg":
            iconRes = "file_jpg"
            break;
        default:
            iconRes = "file_unknow"
        }
        return iconRes
    }
    
}


