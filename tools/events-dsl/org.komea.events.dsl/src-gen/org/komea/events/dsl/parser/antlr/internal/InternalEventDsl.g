/*
* generated by Xtext
*/
grammar InternalEventDsl;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.komea.events.dsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.komea.events.dsl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.komea.events.dsl.services.EventDslGrammarAccess;

}

@parser::members {

 	private EventDslGrammarAccess grammarAccess;
 	
    public InternalEventDslParser(TokenStream input, EventDslGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "EventFactory";	
   	}
   	
   	@Override
   	protected EventDslGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleEventFactory
entryRuleEventFactory returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getEventFactoryRule()); }
	 iv_ruleEventFactory=ruleEventFactory 
	 { $current=$iv_ruleEventFactory.current; } 
	 EOF 
;

// Rule EventFactory
ruleEventFactory returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((	otherlv_0='package' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getEventFactoryAccess().getPackageKeyword_0_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getEventFactoryAccess().getPackageQualifiedNameParserRuleCall_0_1_0()); 
	    }
		lv_package_1_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getEventFactoryRule());
	        }
       		set(
       			$current, 
       			"package",
        		lv_package_1_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2=';' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getEventFactoryAccess().getSemicolonKeyword_0_2());
    }
)?(	otherlv_3='path' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getEventFactoryAccess().getPathKeyword_1_0());
    }
(
(
		lv_path_4_0=RULE_STRING
		{
			newLeafNode(lv_path_4_0, grammarAccess.getEventFactoryAccess().getPathSTRINGTerminalRuleCall_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getEventFactoryRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"path",
        		lv_path_4_0, 
        		"STRING");
	    }

)
)	otherlv_5=';' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getEventFactoryAccess().getSemicolonKeyword_1_2());
    }
)?	otherlv_6='factory' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getEventFactoryAccess().getFactoryKeyword_2());
    }
(
(
		lv_name_7_0=RULE_ID
		{
			newLeafNode(lv_name_7_0, grammarAccess.getEventFactoryAccess().getNameIDTerminalRuleCall_3_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getEventFactoryRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_7_0, 
        		"ID");
	    }

)
)	otherlv_8='{' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getEventFactoryAccess().getLeftCurlyBracketKeyword_4());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getEventFactoryAccess().getEventsEventParserRuleCall_5_0()); 
	    }
		lv_events_9_0=ruleEvent		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getEventFactoryRule());
	        }
       		add(
       			$current, 
       			"events",
        		lv_events_9_0, 
        		"Event");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_10='}' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getEventFactoryAccess().getRightCurlyBracketKeyword_6());
    }
)
;





// Entry rule entryRuleEvent
entryRuleEvent returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getEventRule()); }
	 iv_ruleEvent=ruleEvent 
	 { $current=$iv_ruleEvent.current; } 
	 EOF 
;

// Rule Event
ruleEvent returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='event' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getEventAccess().getEventKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getEventAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getEventRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getEventAccess().getLeftCurlyBracketKeyword_2());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getEventAccess().getPropertiesEventPropertyParserRuleCall_3_0_0()); 
	    }
		lv_properties_3_0=ruleEventProperty		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getEventRule());
	        }
       		add(
       			$current, 
       			"properties",
        		lv_properties_3_0, 
        		"EventProperty");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4=';' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getEventAccess().getSemicolonKeyword_3_1());
    }
)*	otherlv_5='}' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getEventAccess().getRightCurlyBracketKeyword_4());
    }
)
;





// Entry rule entryRuleEventProperty
entryRuleEventProperty returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getEventPropertyRule()); }
	 iv_ruleEventProperty=ruleEventProperty 
	 { $current=$iv_ruleEventProperty.current; } 
	 EOF 
;

// Rule EventProperty
ruleEventProperty returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getEventPropertyAccess().getSimplePropertyParserRuleCall_0()); 
    }
    this_SimpleProperty_0=ruleSimpleProperty
    { 
        $current = $this_SimpleProperty_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getEventPropertyAccess().getListPropertyParserRuleCall_1()); 
    }
    this_ListProperty_1=ruleListProperty
    { 
        $current = $this_ListProperty_1.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleSimpleProperty
entryRuleSimpleProperty returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSimplePropertyRule()); }
	 iv_ruleSimpleProperty=ruleSimpleProperty 
	 { $current=$iv_ruleSimpleProperty.current; } 
	 EOF 
;

// Rule SimpleProperty
ruleSimpleProperty returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getSimplePropertyAccess().getTypeQualifiedNameParserRuleCall_0_0()); 
	    }
		lv_type_0_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSimplePropertyRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_0_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getSimplePropertyAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSimplePropertyRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(	otherlv_2='=' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getSimplePropertyAccess().getEqualsSignKeyword_2_0());
    }
(
(
		lv_value_3_0=RULE_STRING
		{
			newLeafNode(lv_value_3_0, grammarAccess.getSimplePropertyAccess().getValueSTRINGTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSimplePropertyRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"value",
        		lv_value_3_0, 
        		"STRING");
	    }

)
))?)
;





// Entry rule entryRuleListProperty
entryRuleListProperty returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getListPropertyRule()); }
	 iv_ruleListProperty=ruleListProperty 
	 { $current=$iv_ruleListProperty.current; } 
	 EOF 
;

// Rule ListProperty
ruleListProperty returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getListPropertyAccess().getTypeQualifiedNameParserRuleCall_0_0()); 
	    }
		lv_type_0_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getListPropertyRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_0_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='[]' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getListPropertyAccess().getLeftSquareBracketRightSquareBracketKeyword_1());
    }
(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getListPropertyAccess().getNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getListPropertyRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"ID");
	    }

)
)(	otherlv_3='=' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getListPropertyAccess().getEqualsSignKeyword_3_0());
    }
	otherlv_4='{' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getListPropertyAccess().getLeftCurlyBracketKeyword_3_1());
    }
(
(
		lv_values_5_0=RULE_STRING
		{
			newLeafNode(lv_values_5_0, grammarAccess.getListPropertyAccess().getValuesSTRINGTerminalRuleCall_3_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getListPropertyRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"values",
        		lv_values_5_0, 
        		"STRING");
	    }

)
)(	otherlv_6=',' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getListPropertyAccess().getCommaKeyword_3_3_0());
    }
(
(
		lv_values_7_0=RULE_STRING
		{
			newLeafNode(lv_values_7_0, grammarAccess.getListPropertyAccess().getValuesSTRINGTerminalRuleCall_3_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getListPropertyRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"values",
        		lv_values_7_0, 
        		"STRING");
	    }

)
))*	otherlv_8='}' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getListPropertyAccess().getRightCurlyBracketKeyword_3_4());
    }
)?)
;





// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); } 
	 iv_ruleQualifiedName=ruleQualifiedName 
	 { $current=$iv_ruleQualifiedName.current.getText(); }  
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
    }
    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
    }
)*)
    ;





RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;

