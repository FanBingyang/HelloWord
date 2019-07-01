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

    config.language = 'zh-cn';/*���༭������������Ϊ����*/

    config.image_previewText = ' ';/*ȥ��ͼƬԤ���������*/

    config.removeDialogTabs = 'image:advanced;image:Link';//���س�������߼�ѡ��

    //���ð���ʱӦ������һ���ⲿ�ļ��������λ�������������ť�����¡�
    // config.filebrowserBrowseUrl = "D:/";
    /*������������ͼ�����ļ��ϴ����ܣ������urlΪͼƬ�ϴ�Ҫָ��ĵ�action��servlet*/
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
