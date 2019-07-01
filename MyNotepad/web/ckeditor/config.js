/**
 * @license Copyright (c) 2003-2019, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
    // 	// Define changes to default configuration here. For example:
    // 	// config.language = 'fr';
	// config.uiColor = '#AADC6E';

    config.width = 900;
    config.height = 500;

    config.language = 'zh-cn';/*将编辑器的语言设置为中文*/

    config.image_previewText = ' ';/*去掉图片预览框的文字*/

    config.removeDialogTabs = 'image:advanced;image:Link';//隐藏超链接与高级选项

    //设置包含时应该启动一个外部文件浏览器的位置浏览服务器按钮被按下。
    // config.filebrowserBrowseUrl = "D:/";
    /*开启工具栏“图像”中文件上传功能，后面的url为图片上传要指向的的action或servlet*/
    config.filebrowserImageUploadUrl= "/uploader";
    config.toolbar= [
        ['Templates','Cut ','Copy ','Paste','PasteText'],
        ["SpellChecker","Undo","Redo","Find","Replace"],
        ["Bold","Italic","Underline","Strike",'Subscript','Superscript'],
        ["NumberedList","BulletedList","-","HorizontalRule","Blockquote","CodeSnippet","-","JustifyLeft","JustifyCenter","JustifyRight","JustifyBlock","JustfyBlock"],
        ["Image"],["Table"],["Link"],["Unlink"],
        ["Smiley","SpecialChar"],
        ["Styles","Format","Font","FontSize"],
        ["TextColor","BGColor"]];
};
